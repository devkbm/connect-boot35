package com.like.cooperation.board.application.port.in.post;

import com.like.cooperation.board.application.dto.post.PostFormSelectDTO;

public interface PostSelectUseCase {
	PostFormSelectDTO select(String readerUserId, Long articleId);	
}
