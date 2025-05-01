package com.example.webclipboard.scheduler;

import com.example.webclipboard.service.ClipService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClipCleanupScheduler {
    private final ClipService clipService;

    public ClipCleanupScheduler(ClipService clipService) {
        this.clipService = clipService;
    }

    @Scheduled(fixedRate = 600000) // Run every 10 minutes
    public void cleanupExpiredClips() {
        clipService.cleanupExpiredClips();
    }
}