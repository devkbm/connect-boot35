package com.like.cooperation.board.adapter.in.web.post;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.like.cooperation.board.application.port.in.post.attach.PostAttachedFileDownloadDTO;
import com.like.cooperation.board.application.port.in.post.attach.PostAttachedFileDownloadUseCase;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PostAttachedFileDownloadController {

	PostAttachedFileDownloadUseCase useCase;
	
	PostAttachedFileDownloadController(PostAttachedFileDownloadUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/grw/board/post/file/{id}")
	public HttpServletResponse fileDownLoad(HttpServletResponse response, @PathVariable Long id) throws Exception {														
		PostAttachedFileDownloadDTO fileDTO = useCase.download(id);		
		
		setResponse(response, fileDTO.size(), fileDTO.fileName(), "application/octet-stream");
		
		try (OutputStream os = response.getOutputStream()) {			
			fileToStream(fileDTO.file(), os);			
		} catch (IOException e1) {		
			e1.printStackTrace();
		}
						
		return response;
	}
	
	private void setResponse(HttpServletResponse response, long fileSize, String fileName, String mimeType) {
		// get MIME type of the file		
		if (StringUtils.hasText(mimeType)) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";	         
		}
		
		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLengthLong(fileSize);
		response.setCharacterEncoding("UTF-8");
		
		// set headers for the response
		String headerFileName = "";
		try {
			headerFileName = new String(fileName.getBytes("EUC-KR"), "8859_1");			
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}				
		
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment;filename=\"%s\"", headerFileName);
		
		response.setHeader(headerKey, headerValue);
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");		
	}
	
	private void fileToStream(File file, OutputStream os) throws FileNotFoundException, IOException {
		
		try (
			FileInputStream 	fis = new FileInputStream(file);
			FileChannel 		inChannel = fis.getChannel();
			WritableByteChannel outChannel = Channels.newChannel(os);) {										
			
			inChannel.transferTo(0, fis.available(), outChannel);			
		}		
	}	
	
}
