package com.like.cooperation.board.application.service.post;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.adapter.out.file.PostAttachedFileServerRepository;
import com.like.cooperation.board.application.port.in.post.attach.PostAttachedFileDeleteUseCase;
import com.like.cooperation.board.application.port.out.post.PostAttachedFileDbPort;
import com.like.cooperation.board.application.port.out.post.PostCommandDbPort;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostAttachedFile;

@Service
public class PostAttachedFileDeleteService implements PostAttachedFileDeleteUseCase {

	PostCommandDbPort dbPort;
	PostAttachedFileDbPort attachedFileDbPort;	
	PostAttachedFileServerRepository fileServerRepository;
	
	PostAttachedFileDeleteService(
			PostCommandDbPort dbPort,
			PostAttachedFileDbPort attachedFileDbPort,			
			PostAttachedFileServerRepository fileServerRepository
			) {
		this.dbPort = dbPort;
		this.attachedFileDbPort = attachedFileDbPort;			
		this.fileServerRepository = fileServerRepository;
	}
	
	@Override
	public void delete(String postId, String fileId) throws FileNotFoundException {
		
		Post entity = this.dbPort.select(Long.parseLong(postId))
								 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시글입니다." + postId));
		
		
		Optional<PostAttachedFile> attachedFile = entity.getAttachedFileInfoList()
														.stream()
														.filter(e -> e.getPostFileId().toString().equals(fileId))
														.findFirst();
				
		this.fileServerRepository.deleteFile(new File(attachedFile.get().getPath(), attachedFile.get().getUuid()));
		
		
		this.attachedFileDbPort.delete(attachedFile.get().getPostFileId());
		
		entity.getAttachedFileInfoList().remove(attachedFile.get());			
					
	}

}
