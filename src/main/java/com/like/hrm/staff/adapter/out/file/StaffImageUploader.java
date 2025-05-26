package com.like.hrm.staff.adapter.out.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.like.system.file.config.FileServerProperties;

@Repository
public class StaffImageUploader  {
	
	FileServerProperties properties;
	
	StaffImageUploader(FileServerProperties properties) {		
		this.properties = properties;
	}
	
	public File uploadFile(String companyCode, String staffNo, MultipartFile sourceFile) throws FileNotFoundException, IOException {
		String fileServerPath = this.properties.getLocation();		
		String extension = StringUtils.getFilenameExtension(sourceFile.getOriginalFilename());	
		String fileName = staffNo + "." + extension;
		
		File file = new File(fileServerPath, fileName);
		copy(sourceFile, file);
		
		return file;
	}	
	
	private void copy(MultipartFile sourceFile, File file) throws FileNotFoundException, IOException {
		if(sourceFile == null || sourceFile.isEmpty()) throw new FileNotFoundException();				
								
		try (ReadableByteChannel	cin = Channels.newChannel(sourceFile.getInputStream());	
			 FileOutputStream 		fos = new FileOutputStream(file);
			 FileChannel 			cout = fos.getChannel();) {			
						
			 cout.transferFrom(cin, 0, sourceFile.getInputStream().available());						 				
		}			
	}
}
