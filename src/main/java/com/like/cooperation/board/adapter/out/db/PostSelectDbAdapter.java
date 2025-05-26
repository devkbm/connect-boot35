package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.PostAttachedFileRepository;
import com.like.cooperation.board.adapter.out.db.querydsl.PostSelectQuerydsl;
import com.like.cooperation.board.application.dto.post.PostFormSelectDTO;
import com.like.cooperation.board.application.port.out.post.PostSelectDbPort;
import com.like.cooperation.board.domain.post.PostAttachedFile;
import com.like.cooperation.board.domain.post.QPostAttachedFile;

@Repository
public class PostSelectDbAdapter implements PostSelectDbPort {

	PostSelectQuerydsl query;
	PostAttachedFileRepository fileRepository;
	
	private final QPostAttachedFile qArticleAttachedFile = QPostAttachedFile.postAttachedFile;
	
	PostSelectDbAdapter(
			PostSelectQuerydsl query, 
			PostAttachedFileRepository fileRepository) {
		this.query = query;
		this.fileRepository = fileRepository;		
	}
	
	@Override
	public PostFormSelectDTO get(String readerUserId, Long articleId) {
		 PostFormSelectDTO dto = this.query.get(readerUserId, articleId);
		 
		 List<PostAttachedFile> files = this.fileRepository.findAll(qArticleAttachedFile.post.postId.eq(articleId));
		 
		 if (!files.isEmpty()) {
			 dto.addFileList(files);
		 }
		 		 
		return dto;
	}

}
