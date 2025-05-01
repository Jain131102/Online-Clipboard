package com.example.webclipboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebClipboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebClipboardApplication.class, args);
    }
}