package com.like.cooperation.board.application.port.in.post;

import com.like.cooperation.board.application.dto.post.PostAttachedFileDownloadDTO;

public interface PostAttachedFileDownloadUseCase {

	PostAttachedFileDownloadDTO download(Long postFileId);
}
