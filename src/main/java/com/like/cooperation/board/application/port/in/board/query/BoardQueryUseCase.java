package com.like.cooperation.board.application.port.in.board.query;

import java.util.List;

public interface BoardQueryUseCase {	
	
	List<BoardQueryResultDTO> selectList(BoardQueryDTO dto);
	
	List<BoardHierarchy> selectHierarchy();
}
