package com.like.cooperation.board.application.service.board;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.board.delete.BoardDeleteUseCase;
import com.like.cooperation.board.application.port.out.board.BoardCommandDbPort;

@Service
public class BoardDeleteService implements BoardDeleteUseCase {

	BoardCommandDbPort dbPort;
	
	BoardDeleteService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);
	}

}
