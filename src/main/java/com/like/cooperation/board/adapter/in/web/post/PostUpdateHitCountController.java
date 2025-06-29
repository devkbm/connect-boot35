package com.like.cooperation.board.adapter.in.web.post;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.cooperation.board.application.port.in.post.save.PostUserHitCountUseCase;
import com.like.cooperation.board.util.Base64Util;

@RestController
public class PostUpdateHitCountController {

	PostUserHitCountUseCase useCase;
	
	PostUpdateHitCountController(PostUserHitCountUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/grw/board/post/hitcnt")
	public ResponseEntity<?> updateArticleHitCnt(@RequestParam String id,
												 @RequestParam String userId) {								
				
		useCase.plusHitCount(Base64Util.fromBase64Decode(id), userId);			
										
		return toOne(null, String.format("%d건 업데이트 하였습니다.", 1));
	}
}
