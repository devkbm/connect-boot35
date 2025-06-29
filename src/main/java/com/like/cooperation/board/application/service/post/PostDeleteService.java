package com.like.cooperation.board.application.service.post;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.post.delete.PostDeleteUseCase;
import com.like.cooperation.board.application.port.out.post.PostCommandDbPort;

@Service
public class PostDeleteService implements PostDeleteUseCase {

	PostCommandDbPort port;
	
	PostDeleteService(PostCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(Long articleId) {
		this.port.delete(articleId);		
	}

}
