package com.like.cooperation.board.application.port.in.post;

import com.like.cooperation.board.application.dto.post.PostFormSaveDTO;

public interface PostSaveByJsonUseCase {
	Long save(PostFormSaveDTO dto);	
}
