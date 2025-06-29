package com.like.cooperation.board.application.service.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.post.upload.PostExcelUploadDTO;
import com.like.cooperation.board.application.port.in.post.upload.PostExcelUploadUseCase;
import com.like.cooperation.board.application.port.out.board.BoardCommandDbPort;
import com.like.cooperation.board.application.port.out.post.PostCommandDbPort;
import com.like.cooperation.board.domain.board.Board;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostContents;
import com.like.cooperation.board.util.Base64Util;

@Service
public class PostExcelUploadService implements PostExcelUploadUseCase {

	BoardCommandDbPort boardDbPort;
	PostCommandDbPort dbPort;
	
	PostExcelUploadService(
			BoardCommandDbPort boardDbPort,
			PostCommandDbPort dbPort
			) {
		this.boardDbPort = boardDbPort;
		this.dbPort = dbPort;
	}
	
	@Override
	public void upload(List<PostExcelUploadDTO> dtoList, String userId) {
		
		List<Post> posts = new ArrayList<>(dtoList.size());
		
		for (PostExcelUploadDTO dto : dtoList) {
			Board board = boardDbPort.select(Long.parseLong(dto.boardId()))
	 				 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));
			
			/*
			Board board = boardDbPort.select(Base64Util.fromBase64Decode(dto.boardId()))
					 				 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));
			*/					
			Post post = new Post(
					dto.clientAppUrl(),
					userId,
					board, 
					new PostContents(dto.title(), dto.contents())
					);
			
			posts.add(post);
		}
		
		this.dbPort.save(posts);		
	}

}
