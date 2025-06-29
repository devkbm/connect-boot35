package com.like.cooperation.board.application.service.board;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.board.select.BoardSelectDTO;
import com.like.cooperation.board.application.port.in.board.select.BoardSelectDTOMapper;
import com.like.cooperation.board.application.port.in.board.select.BoardSelectUseCase;
import com.like.cooperation.board.application.port.out.board.BoardCommandDbPort;

@Service
public class BoardSelectService implements BoardSelectUseCase {

	BoardCommandDbPort dbPort;
	
	BoardSelectService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public BoardSelectDTO select(Long boardId) {
		return BoardSelectDTOMapper.toDTO(this.dbPort.select(boardId).orElse(null));
	}

}
