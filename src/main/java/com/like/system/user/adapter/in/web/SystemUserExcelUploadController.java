package com.like.system.user.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.like.core.message.MessageUtil;
import com.like.excel.upload.ExcelUploader;
import com.like.system.user.application.dto.SystemUserSaveByExcelDTO;
import com.like.system.user.application.dto.SystemUserSaveByExcelDTO2;
import com.like.system.user.application.dto.SystemUserSaveByExcelDTOMapper;
import com.like.system.user.application.port.in.SystemUserExcelUploadUseCase;
import com.like.system.user.application.port.in.SystemUserSaveUseCase;

@Controller
public class SystemUserExcelUploadController {

	SystemUserSaveUseCase useCase;
	
	SystemUserExcelUploadUseCase uploadUseCase;
	
	public SystemUserExcelUploadController(SystemUserSaveUseCase useCase, SystemUserExcelUploadUseCase uploadUseCase) {		
		this.useCase = useCase;
		this.uploadUseCase = uploadUseCase;
	}		
	
	//@PostMapping("/api/system/user-excel")	
	public ResponseEntity<?> ss(MultipartFile file) {
		
		List<SystemUserSaveByExcelDTO> list = SystemUserSaveByExcelDTOMapper.map(file);
		
		useCase.save(list);
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	
	
	@PostMapping("/api/system/user-excel2")	
	public ResponseEntity<?> ss2(MultipartFile file) {
				
		ExcelUploader<SystemUserSaveByExcelDTO> uploader = new ExcelUploader<>(SystemUserSaveByExcelDTO.class);
		List<SystemUserSaveByExcelDTO> list = uploader.map(file);
		
		useCase.save(list);
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	
	@PostMapping("/api/system/user-excel")	
	public ResponseEntity<?> ss3(MultipartFile file) {
		
		ExcelUploader<SystemUserSaveByExcelDTO2> uploader = new ExcelUploader<>(SystemUserSaveByExcelDTO2.class);
		List<SystemUserSaveByExcelDTO2> list = uploader.map(file);
		
		uploadUseCase.save(list);
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
