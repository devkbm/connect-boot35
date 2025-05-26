package com.like.cooperation.board.application.port.in.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.like.cooperation.board.application.dto.post.PostListDTO;
import com.like.cooperation.board.application.dto.post.PostQueryDTO;

public interface PostQueryBySliceUseCase {
	
	Slice<PostListDTO> getAritlceSlice(String userId, PostQueryDTO dto, Pageable pageable);
}
