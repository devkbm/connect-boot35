package com.like.cooperation.board.application.service.post;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.like.cooperation.board.adapter.out.file.PostAttachedFileServerRepository;
import com.like.cooperation.board.application.port.in.post.attach.PostAttachedFileUploadUseCase;
import com.like.cooperation.board.application.port.out.post.PostAttachedFileDbPort;
import com.like.cooperation.board.application.port.out.post.PostCommandDbPort;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostAttachedFile;

@Service
public class PostAttachedFileUploadService implements PostAttachedFileUploadUseCase {

	PostAttachedFileDbPort dbPort;
	PostCommandDbPort postDbPort;
	PostAttachedFileServerRepository fileServerRepository;
	
	PostAttachedFileUploadService(
			PostAttachedFileDbPort dbPort,
			PostCommandDbPort postDbPort,
			PostAttachedFileServerRepository fileServerRepository
			) {
		this.dbPort = dbPort;
		this.postDbPort = postDbPort;
		this.fileServerRepository = fileServerRepository;
	}
	
	@Override
	public void upload(Long postId, List<MultipartFile> mFileList) {
		
		String serverPath = fileServerRepository.getFileServerUploadPath();
		Post post = postDbPort.select(postId).orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));
		List<PostAttachedFile> attachedFiles = new ArrayList<>(mFileList.size());
					
		for (MultipartFile mFile : mFileList) {
			
			PostAttachedFile attachedFile = new PostAttachedFile(post, serverPath, mFile);
			
			toFileServer(mFile, attachedFile.getUuid());
			
			attachedFiles.add(attachedFile);
		}
		
		this.dbPort.save(attachedFiles);						
	}

	
	private void toFileServer(MultipartFile sourceFile, String serverFileName) {
		try {			
			fileServerRepository.fileTransfer(sourceFile, serverFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
