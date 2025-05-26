package com.like.cooperation.board.application.dto.post;

public record PostListDTO(
	Long boardId,
	Long postId,	
	String writerId,
	String writerName,
	String writerImage,
	String title,
	int hitCount,
	Boolean editable,
	Boolean isAttachedFile,
    Integer fileCount,
    Boolean isRead) {	
}

