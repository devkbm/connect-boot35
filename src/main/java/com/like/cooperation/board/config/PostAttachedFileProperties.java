package com.like.cooperation.board.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "board")
public record PostAttachedFileProperties(
		String location, 				// Server File Path
		String clientDownloadUrl		// Client App에서 다운로드하기 위한 URL 경로
		) {
}

