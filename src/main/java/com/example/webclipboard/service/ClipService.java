package com.example.webclipboard.service;

import com.example.webclipboard.model.Clip;
import com.example.webclipboard.model.ClipRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClipService {
	private final ClipRepository clipRepository;

	public ClipService(ClipRepository clipRepository) {
		this.clipRepository = clipRepository;
	}

	public String saveClip(String content) {
		String id = UUID.randomUUID().toString();
		clipRepository.save(new Clip(id, content));
		return id;
	}

	public Optional<String> getClipContent(String id) {
		return clipRepository.findById(id).map(Clip::getContent);
	}

	public void cleanupExpiredClips() {
		LocalDateTime expiryTime = LocalDateTime.now().minusMinutes(10);
		clipRepository.deleteExpiredClips(expiryTime);
	}
}