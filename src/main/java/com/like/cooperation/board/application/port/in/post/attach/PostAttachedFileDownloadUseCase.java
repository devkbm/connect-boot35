package com.like.cooperation.board.application.port.in.post.attach;

public interface PostAttachedFileDownloadUseCase {

	PostAttachedFileDownloadDTO download(Long postFileId);
}
