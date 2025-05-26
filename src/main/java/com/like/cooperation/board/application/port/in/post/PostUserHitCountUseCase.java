package com.like.cooperation.board.application.port.in.post;

public interface PostUserHitCountUseCase {

	void plusHitCount(Long articleId, String userId);
}
