package com.like.cooperation.board.application.port.in.post.save;

import com.like.cooperation.board.domain.board.Board;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostContents;
import com.like.cooperation.board.domain.post.PostPassword;
import com.like.cooperation.board.util.Base64Util;

public class PostSaveDTOMapper {

	public static Post create(PostSaveDTO dto, Board board) {	
		
		Post entity = Post.builder()	
						  .board(board)
						  .postId(Base64Util.fromBase64Decode(dto.postId()))
						  .userId(dto.userId())
						  .content(new PostContents(dto.title(), dto.contents()))						  						  
						  .password(new PostPassword(dto.pwd()))
						  .isFixedTop(dto.isFiexedTop())
						  .build();
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
    
    public static void modify(PostSaveDTO dto, Post entity) {	    		  	    	
    	entity.modify(dto.clientAppUrl(), new PostContents(dto.title(), dto.contents()), dto.isFiexedTop());
    	    	
	}
}
