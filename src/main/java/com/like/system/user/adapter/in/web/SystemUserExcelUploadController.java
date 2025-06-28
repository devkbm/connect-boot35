package com.like.system.user.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.like.core.message.MessageUtil;
import com.like.excel.upload.ExcelUploader;
import com.like.system.user.application.port.in.upload.SystemUserExcelUploadUseCase;
import com.like.system.user.application.port.in.upload.SystemUserExcelUploadDTO2;

@Controller
public class SystemUserExcelUploadController {
	
	SystemUserExcelUploadUseCase uploadUseCase;
	
	public SystemUserExcelUploadController(SystemUserExcelUploadUseCase uploadUseCase) {				
		this.uploadUseCase = uploadUseCase;
	}		
		
	
	@PostMapping("/api/system/user-excel")	
	public ResponseEntity<?> ss3(MultipartFile file) {
		
		ExcelUploader<SystemUserExcelUploadDTO2> uploader = new ExcelUploader<>(SystemUserExcelUploadDTO2.class);
		List<SystemUserExcelUploadDTO2> list = uploader.map(file);
		
		uploadUseCase.save(list);
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
