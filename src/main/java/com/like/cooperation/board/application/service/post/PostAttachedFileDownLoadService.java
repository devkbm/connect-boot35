package com.like.cooperation.board.application.service.post;

import java.io.File;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.post.attach.PostAttachedFileDownloadDTO;
import com.like.cooperation.board.application.port.in.post.attach.PostAttachedFileDownloadUseCase;
import com.like.cooperation.board.application.port.out.post.PostAttachedFileDbPort;
import com.like.cooperation.board.domain.post.PostAttachedFile;

@Service
public class PostAttachedFileDownLoadService implements PostAttachedFileDownloadUseCase {

	PostAttachedFileDbPort dbPort;
	
	PostAttachedFileDownLoadService(PostAttachedFileDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public PostAttachedFileDownloadDTO download(Long postFileId) {
		PostAttachedFile attachedFile = this.dbPort.select(postFileId).orElse(null);
		File file = new File(attachedFile.getPath(), attachedFile.getUuid());
					
		return new PostAttachedFileDownloadDTO(file, attachedFile.getSize(), attachedFile.getFileName(), attachedFile.getContentType());
	}

}
