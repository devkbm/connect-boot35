package com.like.cooperation.board.application.service.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.board.application.dto.board.BoardHierarchy;
import com.like.cooperation.board.application.dto.board.BoardQueryDTO;
import com.like.cooperation.board.application.dto.board.BoardSaveDTO;
import com.like.cooperation.board.application.port.in.board.BoardQueryUseCase;
import com.like.cooperation.board.application.port.out.board.BoardQueryDbPort;

@Transactional(readOnly=true)
@Service
public class BoardQueryService implements BoardQueryUseCase {

	BoardQueryDbPort port;
	
	BoardQueryService(BoardQueryDbPort port) {
		this.port = port;
	}	
	
	@Override
	public List<BoardSaveDTO> selectList(BoardQueryDTO dto) {
		return this.port.selectList(dto);
	}

	@Override
	public List<BoardHierarchy> selectHierarchy() {
		return this.port.selectHierarchy();
	}

}
