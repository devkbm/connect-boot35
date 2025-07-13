package com.like.cooperation.board.adapter.out.db.querydsl;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.application.port.in.post.select.PostSelectDTO;
import com.like.cooperation.board.domain.post.QPost;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PostSelectQuerydsl {
		
	private final QPost qPost = QPost.post;			
	
	private JPAQueryFactory queryFactory;
	
	PostSelectQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}	
	
	
	public PostSelectDTO get(String readerUserId, Long postId) {
		
		Expression<Boolean> editable = new CaseBuilder()
				.when(qPost.userId.eq(readerUserId)).then(true)				
				.otherwise(false)		
				.as("editable");
		
		return queryFactory
				.select(
					Projections.fields(PostSelectDTO.class,
						/*	
						Expressions.asString(qPost.board.boardId.toString()).as("boardId"),
						Expressions.asString(qPost.postId.toString()).as("postId"),
						Expressions.asString(qPost.postParentId.toString()).as("postParentId"),
						*/						
						qPost.board.boardId.stringValue().as("boardId"),
						qPost.postId.stringValue().as("postId"),
						qPost.postParentId.stringValue().as("postParentId"),
						qPost.userId.as("userName"),
						qPost.content.title,
						qPost.content.contents,
						qPost.hitCount,
						qPost.depth,
						editable
					))
			   .from(qPost)				
			   .where(qPost.postId.eq(postId))
			   .fetchFirst();
	}	
	
}
