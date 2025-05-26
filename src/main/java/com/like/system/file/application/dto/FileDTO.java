package com.like.system.file.application.dto;

import java.io.File;

public record FileDTO(
		File file,
		long size,
		String fileName,
		String mimeType
		) {

}
