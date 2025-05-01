package com.example.webclipboard.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clips")
public class Clip {
    @Id
    private String id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    public Clip() {
        // No-args constructor
    }

    public Clip(String id, String content) {
        this.id = id;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}