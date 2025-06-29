package com.like.cooperation.board.adapter.in.web.post;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.like.cooperation.board.application.port.in.post.attach.PostAttachedFileUploadUseCase;

@Controller
public class PostAttachedFileUploadController {
	
	PostAttachedFileUploadUseCase useCase;
	
	PostAttachedFileUploadController(PostAttachedFileUploadUseCase useCase) {
		this.useCase = useCase;
	}	

	@PostMapping("/api/grw/board/post/file")
	public ResponseEntity<?> fileUpload(final MultipartHttpServletRequest request, @RequestParam Long postId) throws Exception {
						
		List<MultipartFile> multipartFiles = convert(request);
								
		useCase.upload(postId, multipartFiles);
		
		//List<FileResponseDTO> fileList = toDTO(list);
				
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
						 					
		//return new ResponseEntity<List<PostAttachedFileDTO>>(list, responseHeaders, HttpStatus.OK);
		return new ResponseEntity<String>(null, responseHeaders, HttpStatus.OK);
	}
	
	private List<MultipartFile> convert(MultipartHttpServletRequest request) {				
		final Map<String, MultipartFile> fileMap = request.getFileMap();
		Iterator<Entry<String,MultipartFile>> itr = fileMap.entrySet().iterator();		
		List<MultipartFile> multipartFiles = new ArrayList<>(fileMap.entrySet().size());
		
		while ( itr.hasNext() ) {			
			Entry<String,MultipartFile> entry = itr.next();
			multipartFiles.add(entry.getValue());																	
		}					
		
		return multipartFiles;
	}
		
}
