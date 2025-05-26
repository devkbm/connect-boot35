package com.like.cooperation.board.application.dto.board;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record BoardSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String companyCode,
		Long boardId,
		Long boardParentId,
		String boardType,
		@NotEmpty(message="게시판명은 필수 입력사항입니다.")
		String boardName,
		String boardDescription,			
		Boolean useYn,			
		long sequence
		) {
		
}
