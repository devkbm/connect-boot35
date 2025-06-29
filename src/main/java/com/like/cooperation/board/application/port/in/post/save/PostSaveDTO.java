package com.like.cooperation.board.application.port.in.post.save;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public record PostSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String companyCode,
		String boardId,
		String postId,
		String postParentId,
		String userId,
		@NotEmpty(message="제목은 필수 입력 사항입니다.")
		String title,
		String contents,
		String pwd,
		int hitCount,			
		Integer seq,
		Integer depth,
		boolean isFiexedTop,
		List<String> attachFile
		) {
	
        
}
