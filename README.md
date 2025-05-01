# 📋 Web Clipboard Application

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.5-brightgreen)
![H2 Database](https://img.shields.io/badge/H2-2.2.224-lightgrey)
![Render](https://img.shields.io/badge/Deployed_on-Render-5468ff)

A rich-text web clipboard application that lets you save and share formatted text snippets with auto-expiring links.

## ✨ Features

- **Rich Text Editing**: Full-featured editor with Quill.js
- **Auto-Expiring Links**: Content expires after 10 minutes
- **Shareable URLs**: Unique URL for each saved clip
- **Persistent Storage**: H2 database with file persistence
- **Easy Deployment**: One-click deploy to Render

## 🚀 Quick Start

### Prerequisites
- Java 21 JDK
- Maven 3.6+
- Docker (for containerized deployment)

### 🖥️ Local Development
```bash
# Clone the repository
git clone https://github.com/Jain131102/Online-Clipboard.git
cd web-clipboard

# Build and run
./mvnw spring-boot:run

# Access at http://localhost:8080
```

## 🛡 License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).
 
