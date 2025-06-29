package com.like.cooperation.board.application.service.post;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.post.select.PostSelectDTO;
import com.like.cooperation.board.application.port.in.post.select.PostSelectUseCase;
import com.like.cooperation.board.application.port.out.post.PostSelectDbPort;

@Service
public class PostSelectService implements PostSelectUseCase {
	

	PostSelectDbPort port;
	
	PostSelectService(PostSelectDbPort port) {				
		this.port = port;
	}
	
	@Override
	public PostSelectDTO select(String readerUserId, Long articleId) {
		
		return this.port.get(readerUserId, articleId);
	}

}
