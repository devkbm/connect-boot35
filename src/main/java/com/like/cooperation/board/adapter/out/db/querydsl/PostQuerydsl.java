package com.like.cooperation.board.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.domain.post.QPost;
import com.like.cooperation.board.domain.post.QPostAttachedFile;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostQueryRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PostQuerydsl implements PostQueryRepository {

	private JPAQueryFactory queryFactory;
	
	private final QPost qPost = QPost.post;	
	private final QPostAttachedFile qAttachedFile = QPostAttachedFile.postAttachedFile;
	// private final QArticleCheck qArticleCheck = QArticleCheck.articleCheck;	
	
	public PostQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}	
	
	public List<Post> getArticleList(Long boardId) { 			
		
		return queryFactory.select(qPost)
						   .from(qPost)	
						   .leftJoin(qPost.files, qAttachedFile)
						   .fetchJoin()
						   .where(qPost.board.boardId.eq(boardId))							
						   .fetch();				
	}
	
	@Override
	public List<Post> getArticleList(Predicate condition) {
		return queryFactory.select(qPost).distinct()
				   .from(qPost)		  				   
				   .leftJoin(qPost.files, qAttachedFile)
				   .fetchJoin()		  				   				   
				   .where(condition)
				   .orderBy(qPost.postId.desc())
				   .fetch();
	}	
	
}
