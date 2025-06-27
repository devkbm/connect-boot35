package com.like.system.user.adapter.in.web.SystemUserImage;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.like.system.file.adapter.out.file.FileConverterUtil;
import com.like.system.user.application.port.in.select.SystemUserSelectDTO;
import com.like.system.user.application.port.in.select.SystemUserSelectUseCase;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SystemUserImageDownloadController {

	SystemUserSelectUseCase useCase;
	
	SystemUserImageDownloadController(SystemUserSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	
	@GetMapping("/api/system/user/image")
	public void down(String companyCode, String userId, HttpServletResponse response) {
		SystemUserSelectDTO dto = useCase.selectDTO(userId, companyCode);
		
		File file = new File(dto.imageBase64());
		
		this.setResponse(response, file.length(), userId, "application/octet-stream");
						
		try (OutputStream os = response.getOutputStream()) {			
			FileConverterUtil.fileToStream(file, os);			
		} catch (IOException e1) {		
			e1.printStackTrace();
		}
	}
	
	public HttpServletResponse setResponse(HttpServletResponse response, long fileSize, String fileName, String mimeType) {
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
		
		return response;
	}

}
