package com.like.cooperation.board.adapter.in.web.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.like.cooperation.board.application.port.in.post.query.PostQueryResultDTO;
import com.like.cooperation.board.application.port.in.post.query.PostQueryBySliceUseCase;
import com.like.cooperation.board.application.port.in.post.query.PostQueryDTO;
import com.like.core.util.SessionUtil;

@Controller
public class PostQueryBySliceController {

	PostQueryBySliceUseCase useCase;
	
	PostQueryBySliceController(PostQueryBySliceUseCase useCase) {
		this.useCase = useCase;
	}	
	
	@GetMapping("/api/grw/board/post_slice")
	public ResponseEntity<?> getSlice(PostQueryDTO dto, Pageable pageable) {
																			  											
		Slice<PostQueryResultDTO> list = useCase.getAritlceSlice(SessionUtil.getUserId(), dto, pageable);
		
		return new ResponseEntity<Slice<PostQueryResultDTO>>(list, HttpStatus.OK);		
	}
}
