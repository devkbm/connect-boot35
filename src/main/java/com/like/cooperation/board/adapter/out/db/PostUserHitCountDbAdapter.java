package com.like.cooperation.board.adapter.out.db;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.PostUserHitCountRepository;
import com.like.cooperation.board.application.port.out.post.PostUserHitCountDbPort;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostUserHitCount;
import com.like.cooperation.board.domain.post.PostUserHitCountId;

@Repository
public class PostUserHitCountDbAdapter implements PostUserHitCountDbPort {

	PostUserHitCountRepository repository;
	
	PostUserHitCountDbAdapter(PostUserHitCountRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void plusHitCount(Post article, String userId) {
		
		PostUserHitCount isRead = this.repository.findById(new PostUserHitCountId(article, userId))
				                            .orElse(new PostUserHitCount(article, userId));

		isRead.updateHitCnt();

		this.repository.save(isRead);
	}

}
