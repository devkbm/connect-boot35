package com.like.cooperation.board.application.port.in.post;

import com.like.cooperation.board.application.dto.post.PostSaveMultipartDTO;

public interface PostSaveByMultiPartUseCase {	
	
	void save(PostSaveMultipartDTO dto);
		
}
