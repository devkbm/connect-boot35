package com.like.cooperation.board.application.service.post;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.post.save.PostUserHitCountUseCase;
import com.like.cooperation.board.application.port.out.post.PostCommandDbPort;
import com.like.cooperation.board.application.port.out.post.PostUserHitCountDbPort;
import com.like.cooperation.board.domain.post.Post;

@Service
public class PostUserHitCountService implements PostUserHitCountUseCase {
	
	PostUserHitCountDbPort port;
	PostCommandDbPort articlePort;
	
	PostUserHitCountService(PostUserHitCountDbPort port
							  ,PostCommandDbPort articlePort) {
		this.port = port;				
		this.articlePort = articlePort;
	}
	
	@Override
	public void plusHitCount(Long articleId, String userId) {
		Post article = this.articlePort.select(articleId)
										  .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시글입니다."));
		
		article.updateHitCnt();
		
		this.port.plusHitCount(article, userId);
	}	

}
