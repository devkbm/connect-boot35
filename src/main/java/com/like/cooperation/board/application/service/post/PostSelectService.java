package com.like.cooperation.board.application.service.post;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.dto.post.PostFormSelectDTO;
import com.like.cooperation.board.application.port.in.post.PostSelectUseCase;
import com.like.cooperation.board.application.port.out.post.PostSelectDbPort;

@Service
public class PostSelectService implements PostSelectUseCase {
	

	PostSelectDbPort port;
	
	PostSelectService(PostSelectDbPort port) {				
		this.port = port;
	}
	
	@Override
	public PostFormSelectDTO select(String readerUserId, Long articleId) {
		
		return this.port.get(readerUserId, articleId);
	}

}
