package com.like.cooperation.board.application.service.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.board.application.port.in.post.query.PostQueryResultDTO;
import com.like.cooperation.board.application.port.in.post.query.PostQueryBySliceUseCase;
import com.like.cooperation.board.application.port.in.post.query.PostQueryDTO;
import com.like.cooperation.board.application.port.out.post.PostQueryBySliceDbPort;

@Transactional(readOnly = true)
@Service
public class PostQueryBySliceService implements PostQueryBySliceUseCase {

	PostQueryBySliceDbPort dbPort;
	
	PostQueryBySliceService(PostQueryBySliceDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public Slice<PostQueryResultDTO> getAritlceSlice(String userId, PostQueryDTO dto, Pageable pageable) {
		return this.dbPort.getAritlceSlice(userId, dto, pageable);
	}

	
}
