package com.like.cooperation.board.application.service.post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.like.cooperation.board.application.port.in.post.save.PostSaveDTO;
import com.like.cooperation.board.application.port.in.post.save.PostSaveDTOMapper;
import com.like.cooperation.board.application.port.in.post.save.PostSaveUseCase;
import com.like.cooperation.board.application.port.out.board.BoardCommandDbPort;
import com.like.cooperation.board.application.port.out.post.PostAttachedFileDbPort;
import com.like.cooperation.board.application.port.out.post.PostCommandDbPort;
import com.like.cooperation.board.domain.board.Board;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.util.Base64Util;
import com.like.system.file.export.FileInfoDTOSelectUseCase;
import com.like.system.file.export.FileUploadUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class PostSaveByJsonService implements PostSaveUseCase {

	BoardCommandDbPort boardDbPort;
	PostCommandDbPort dbPort;
	PostAttachedFileDbPort attachedFileDbPort;
	
	FileUploadUseCase uploadUseCase;	
	FileInfoDTOSelectUseCase fileSelectUseCase;
	
	
	PostSaveByJsonService(
			BoardCommandDbPort boardDbPort,
			PostCommandDbPort dbPort,			
			PostAttachedFileDbPort attachedFileDbPort,
			FileUploadUseCase uploadUseCase,
			FileInfoDTOSelectUseCase fileSelectUseCase
			) {
		this.dbPort = dbPort;
		this.boardDbPort = boardDbPort;
		this.attachedFileDbPort = attachedFileDbPort;
		this.uploadUseCase = uploadUseCase;		
		this.fileSelectUseCase = fileSelectUseCase;
	}
	
	
	@Override
	public Long save(PostSaveDTO dto) {
		log.info(dto.toString());
		Board board = boardDbPort.select(Base64Util.fromBase64Decode(dto.boardId()))
								 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));		
						
		Post entity = StringUtils.hasText(dto.postId()) ? this.findPost(Base64Util.fromBase64Decode(dto.postId())) : null; 
								
		if (entity == null) {
			entity = PostSaveDTOMapper.create(dto, board); 
		} else {
			PostSaveDTOMapper.modify(dto, entity);
		}
				
		this.dbPort.save(entity);					
		
		return entity.getId();
		
	}
	
	private Post findPost(Long postId) {
		return this.dbPort.select(postId).orElse(null);
	}	

}
