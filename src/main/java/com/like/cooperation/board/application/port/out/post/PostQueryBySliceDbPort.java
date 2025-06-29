package com.like.cooperation.board.application.port.out.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.like.cooperation.board.application.port.in.post.query.PostQueryResultDTO;
import com.like.cooperation.board.application.port.in.post.query.PostQueryDTO;

public interface PostQueryBySliceDbPort {
	
	Slice<PostQueryResultDTO> getAritlceSlice(String userId, PostQueryDTO dto, Pageable pageable);
}
