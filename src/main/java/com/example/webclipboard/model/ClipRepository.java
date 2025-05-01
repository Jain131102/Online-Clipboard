package com.example.webclipboard.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface ClipRepository extends JpaRepository<Clip, String> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Clip c WHERE c.createdAt < :expiryTime")
    void deleteExpiredClips(LocalDateTime expiryTime);
}