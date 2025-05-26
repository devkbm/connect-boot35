package com.like.cooperation.board.application.service.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.board.application.dto.post.PostListDTO;
import com.like.cooperation.board.application.dto.post.PostQueryDTO;
import com.like.cooperation.board.application.port.in.post.PostQueryBySliceUseCase;
import com.like.cooperation.board.application.port.out.post.PostQueryBySliceDbPort;

@Transactional(readOnly = true)
@Service
public class PostQueryBySliceService implements PostQueryBySliceUseCase {

	PostQueryBySliceDbPort dbPort;
	
	PostQueryBySliceService(PostQueryBySliceDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public Slice<PostListDTO> getAritlceSlice(String userId, PostQueryDTO dto, Pageable pageable) {
		return this.dbPort.getAritlceSlice(userId, dto, pageable);
	}

	
}
