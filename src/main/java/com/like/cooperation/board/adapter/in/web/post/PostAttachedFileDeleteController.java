package com.like.cooperation.board.adapter.in.web.post;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.io.FileNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.like.cooperation.board.application.port.in.post.attach.PostAttachedFileDeleteUseCase;
import com.like.core.message.MessageUtil;

@Controller
public class PostAttachedFileDeleteController {

	PostAttachedFileDeleteUseCase useCase;
	
	PostAttachedFileDeleteController(PostAttachedFileDeleteUseCase useCase) {
		this.useCase = useCase;
	}
		
	@DeleteMapping("/api/grw/board/post/{id}/file/{fileId}")
	public ResponseEntity<?> delete(@PathVariable String id, @PathVariable String fileId) throws FileNotFoundException {				
												
		useCase.delete(id, fileId);							
		
		return toList(null, MessageUtil.getDeleteMessage(1));
	}
}
