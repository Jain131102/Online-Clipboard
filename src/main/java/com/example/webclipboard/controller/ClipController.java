package com.example.webclipboard.controller;

import com.example.webclipboard.service.ClipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clip")
public class ClipController {
    private final ClipService clipService;

    public ClipController(ClipService clipService) {
        this.clipService = clipService;
    }

    @PostMapping
    public ResponseEntity<SaveResponse> save(@RequestBody SaveRequest request) {
        String id = clipService.saveClip(request.content());
        return ResponseEntity.ok(new SaveResponse(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadResponse> load(@PathVariable String id) {
        Optional<String> content = clipService.getClipContent(id);
        return content.map(c -> ResponseEntity.ok(new LoadResponse(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public record SaveRequest(String content) {}
    public record SaveResponse(String id) {}
    public record LoadResponse(String content) {}
}