package com.like.system.file.application.service;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.file.application.port.in.FileServerDownloadDTO;
import com.like.system.file.application.port.in.FileServerDownloadUseCase;
import com.like.system.file.application.port.out.FileInfoCommandDbPort;
import com.like.system.file.domain.FileInfo;

@Transactional
@Service
public class FileSeverDownloadService implements FileServerDownloadUseCase {

	FileInfoCommandDbPort dbPort;
	
	FileSeverDownloadService(FileInfoCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public FileServerDownloadDTO getDownloadFile(String fileInfoId) {
		FileInfo fileInfo = this.dbPort.getFileInfo(fileInfoId);		
		File file = new File(fileInfo.getPath(), fileInfo.getUuid()); 
		
		fileInfo.plusDownloadCount();		
		
		this.dbPort.save(fileInfo);
		
		return new FileServerDownloadDTO(file, fileInfo.getSize(), fileInfo.getFileName(), fileInfo.getContentType());
	}

}
