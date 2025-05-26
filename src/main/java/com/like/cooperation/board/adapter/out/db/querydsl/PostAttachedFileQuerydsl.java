package com.like.cooperation.board.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.domain.post.QPostAttachedFile;
import com.like.cooperation.board.domain.post.PostAttachedFile;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PostAttachedFileQuerydsl {

	JPAQueryFactory queryFactory;
	
	private final QPostAttachedFile qAttachedFile = QPostAttachedFile.postAttachedFile;
		
	public PostAttachedFileQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public void deleteNotMatched(List<PostAttachedFile> files) {
		List<Long> ids = files.stream()
							  .filter(e -> e.getPostFileId() != null)
							  .map(e -> e.getPostFileId())
							  .toList();
		
		queryFactory.delete(qAttachedFile)
				    .where(qAttachedFile.postFileId.notIn(ids))
				    .execute();
	}
	
	public void deleteAll(Long postId) {
		queryFactory.delete(qAttachedFile)
	    			.where(qAttachedFile.post.postId.eq(postId))
	    			.execute();
	}
	
	
}
