package com.like.cooperation.board.application.port.in.post.query;

import static org.springframework.util.StringUtils.hasText;

import com.like.cooperation.board.domain.post.QPost;
import com.like.cooperation.board.util.Base64Util;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

public record PostQueryDTO(
		String boardId,
		String title,
		String contents
		) {
	private static final QPost qPost = QPost.post;
	
	public BooleanBuilder getBooleanBuilder() {
		BooleanBuilder builder = new BooleanBuilder();
		
		builder
			.and(qPost.board.boardId.eq(Base64Util.fromBase64Decode(this.boardId)))
			.and(likeTitle(this.title))
			.and(likeContents(this.contents));											
		
		return builder;
	}
	
	private BooleanExpression likeTitle(String title) {
		return hasText(title) ? qPost.content.title.like("%"+title+"%") : null;					
	}
	
	private BooleanExpression likeContents(String contents) {
		return hasText(contents) ? qPost.content.contents.like("%"+contents+"%") : null;			
	}
	
}
