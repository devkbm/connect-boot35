package com.like.system.file.application.port.in;

import java.io.File;

public record FileServerDownloadDTO(
		File file,
		long size,
		String fileName,
		String mimeType
		) {

}
