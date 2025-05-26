package com.like.cooperation.board.application.service.board;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.dto.board.BoardSaveDTO;
import com.like.cooperation.board.application.dto.board.BoardSaveDTOMapper;
import com.like.cooperation.board.application.port.in.board.BoardSaveUseCase;
import com.like.cooperation.board.application.port.out.board.BoardCommandDbPort;
import com.like.cooperation.board.domain.board.Board;

@Service
public class BoardSaveService implements BoardSaveUseCase {

	BoardCommandDbPort dbPort;
	
	BoardSaveService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(BoardSaveDTO dto) {
		Board parentBoard = dto.boardParentId() == null ? null : this.dbPort.select(dto.boardParentId()).orElse(null);
		
		this.dbPort.save(BoardSaveDTOMapper.toEntity(dto, parentBoard));		
	}

}
