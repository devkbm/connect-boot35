package com.like.cooperation.board.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "board")
public class PostAttachedFileProperties {

	/**
	 * Server File Path
	 */
	String location;	
	
	/**
	 * Client App에서 다운로드하기 위한 URL 경로
	 */
	String clientDownloadUrl;
		
}
