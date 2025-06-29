package com.like.cooperation.board.application.port.in.post.save;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.like.cooperation.board.domain.board.Board;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostContents;
import com.like.cooperation.board.domain.post.PostPassword;

import jakarta.validation.constraints.NotEmpty;

public record PostSaveByMultipartDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String companyCode,
		Long boardId,
		Long postId,
		Long postParentId,
		@NotEmpty(message="제목은 필수 입력 사항입니다.")
		String title,
		String contents,
		String pwd,
		int hitCount,						
		Integer depth,
		boolean isFiexedTop,
		@JsonIgnore
		List<MultipartFile> file
		) {
	public Post newArticle(Board board) {									    			
		Post entity = Post.builder()	
					    .board(board)
					    .postId(postId)
					    .content(new PostContents(title, contents))						  						  
					    .password(new PostPassword(this.pwd))
					    .isFixedTop(isFiexedTop)
					    .build();
		
		entity.setAppUrl(clientAppUrl);
		
		return entity;
	}
    
    public void modifyArticle(Post entity) {
    	entity.modify(clientAppUrl, new PostContents(title, contents),isFiexedTop);    	    
	}
    
    public boolean isNew() {
    	return this.postId() == null ? true : false;
    }
}
