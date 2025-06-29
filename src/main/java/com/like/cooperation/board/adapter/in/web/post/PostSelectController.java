package com.like.cooperation.board.adapter.in.web.post;

import jakarta.servlet.http.HttpSession;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.like.cooperation.board.application.port.in.post.select.PostSelectDTO;
import com.like.cooperation.board.application.port.in.post.select.PostSelectUseCase;
import com.like.cooperation.board.util.Base64Util;
import com.like.core.message.MessageUtil;
import com.like.core.util.SessionUtil;

@Controller
public class PostSelectController {	
			
	PostSelectUseCase useCase;
	
	public PostSelectController(PostSelectUseCase useCase) {		
		this.useCase = useCase;
	}		
	
	@GetMapping("/api/grw/board/post/{id}")
	public ResponseEntity<?> getArticle(@PathVariable String id, HttpSession session) {						
							
		Long decodedId = Base64Util.fromBase64Decode(id);
		
		PostSelectDTO response = useCase.select(SessionUtil.getUserId(), decodedId);				
		
		return toOne(response, MessageUtil.getQueryMessage(response == null ? 0 : 1));
	}
			
}
