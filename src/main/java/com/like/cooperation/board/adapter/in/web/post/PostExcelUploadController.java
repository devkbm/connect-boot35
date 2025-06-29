package com.like.cooperation.board.adapter.in.web.post;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.like.cooperation.board.application.port.in.post.upload.PostExcelUploadDTO;
import com.like.cooperation.board.application.port.in.post.upload.PostExcelUploadUseCase;
import com.like.core.message.MessageUtil;
import com.like.core.util.SessionUtil;
import com.like.excel.upload.ExcelUploader;

@Controller
public class PostExcelUploadController {
	
	PostExcelUploadUseCase useCase;
	
	PostExcelUploadController(PostExcelUploadUseCase useCase) {
		this.useCase = useCase;
	}
	

	@PostMapping("/api/grw/board/post-excel")	
	public ResponseEntity<?> ss3(MultipartFile file) {
		
		ExcelUploader<PostExcelUploadDTO> uploader = new ExcelUploader<>(PostExcelUploadDTO.class);
		List<PostExcelUploadDTO> list = uploader.map(file);
		
		useCase.upload(list, SessionUtil.getUserId());
		
		return toList(null, MessageUtil.getQueryMessage(list.size()));
	}
}
