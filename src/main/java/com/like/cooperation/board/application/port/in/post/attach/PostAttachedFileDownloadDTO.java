package com.like.cooperation.board.application.port.in.post.attach;

import java.io.File;

public record PostAttachedFileDownloadDTO(
		File file,
		long size,
		String fileName,
		String mimeType
		) {

}
