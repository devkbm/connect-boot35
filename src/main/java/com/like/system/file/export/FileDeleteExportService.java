package com.like.system.file.export;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

import com.like.system.file.adapter.out.file.FileServerRepository;
import com.like.system.file.application.port.out.FileInfoCommandDbPort;
import com.like.system.file.domain.FileInfo;

@Service
public class FileDeleteExportService implements FileDeleteUseCase {

	FileInfoCommandDbPort dbPort;
	FileServerRepository fileServerRepository;
	
	FileDeleteExportService(FileInfoCommandDbPort dbPort, FileServerRepository fileServerRepository) {
		this.dbPort = dbPort;
		this.fileServerRepository = fileServerRepository;
	}
	
	@Override
	public void delete(String fileInfoId) {
		FileInfo fileInfo = dbPort.getFileInfo(fileInfoId);
		
		try {
			fileServerRepository.deleteFile(new File(fileInfo.getPath(), fileInfo.getUuid()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		this.dbPort.delete(fileInfoId);
	}

}
