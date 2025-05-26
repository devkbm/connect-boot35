package com.like.cooperation.board.application.port.out.post;

import com.like.cooperation.board.domain.post.Post;

public interface PostUserHitCountDbPort {
	void plusHitCount(Post article, String userId);
}
