# Build stage
FROM eclipse-temurin:21-jdk-jammy as builder
WORKDIR /workspace/app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy project files
COPY pom.xml .
COPY src src

# Build application
RUN mvn clean package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Runtime stage (keep the same as before)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
RUN mkdir -p /data && chmod a+rwx /data
VOLUME /data
COPY --from=builder /workspace/app/target/dependency/BOOT-INF/lib ./lib
COPY --from=builder /workspace/app/target/dependency/META-INF ./META-INF
COPY --from=builder /workspace/app/target/dependency/BOOT-INF/classes .
ENTRYPOINT ["java", "-cp", ".:lib/*", "com.example.webclipboard.WebClipboardApplication"]