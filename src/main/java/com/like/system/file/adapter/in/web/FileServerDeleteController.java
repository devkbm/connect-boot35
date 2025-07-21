package com.like.system.file.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.file.application.port.in.FileServerDeleteUseCase;

@RestController
public class FileServerDeleteController {

	FileServerDeleteUseCase useCase;

	FileServerDeleteController(FileServerDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	
	@DeleteMapping("/api/system/file/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {				
												
		useCase.delete(id);							
		
		return toList(null, MessageUtil.getDeleteMessage(1));
	}
}
