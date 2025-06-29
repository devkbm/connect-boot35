package com.like.cooperation.board.application.port.in.post.select;

public interface PostSelectUseCase {
	PostSelectDTO select(String readerUserId, Long postId);	
}
