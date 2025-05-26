package com.like.cooperation.board.application.dto.post;

import java.io.File;

public record PostAttachedFileDownloadDTO(
		File file,
		long size,
		String fileName,
		String mimeType
		) {

}
