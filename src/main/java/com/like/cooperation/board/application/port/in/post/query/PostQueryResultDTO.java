package com.like.cooperation.board.application.port.in.post.query;

public record PostQueryResultDTO(
	String boardId,
	String postId,	
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

