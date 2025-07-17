package com.like.system.user.adapter.in.web.SystemUserImage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.like.system.user.adapter.out.file.SystemUserProfileImageUploader;
import com.like.system.user.application.port.in.image.SystemUserImageUploadUseCase;

@Controller
public class SystemUserImageUploadController {
			
	SystemUserImageUploadUseCase useCase;	
	SystemUserProfileImageUploader uploader;
		
	public SystemUserImageUploadController(SystemUserImageUploadUseCase useCase,
										   SystemUserProfileImageUploader uploader) {		
		this.useCase = useCase;		
		this.uploader = uploader;
	}	
	
	
	@PostMapping("/api/system/user/image")
	public ResponseEntity<?> uploadSystemUserImage(@RequestPart MultipartFile file
												  ,@RequestParam String companyCode	
												  ,String userId) throws Exception {				
		
		File uploadedFile = uploader.upload(companyCode, userId, file);
		
		String fileName = useCase.upload(companyCode, userId, uploadedFile);			
							
		return new ResponseEntity<Map<String,Object>>(setUploadResponseBody(fileName), setUploadResponseHeader(), HttpStatus.OK);
	}	
	
	private Map<String, Object> setUploadResponseBody(String fileName) {		
		Map<String, Object> response = new HashMap<>();
		response.put("data", fileName);
		response.put("status", "done");
				
		return response;
	}
	
	private HttpHeaders setUploadResponseHeader() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return responseHeaders;		
	}
}
