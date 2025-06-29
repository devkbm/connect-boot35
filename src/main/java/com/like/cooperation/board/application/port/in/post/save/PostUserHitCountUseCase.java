package com.like.cooperation.board.application.port.in.post.save;

public interface PostUserHitCountUseCase {

	void plusHitCount(Long postId, String userId);
}
