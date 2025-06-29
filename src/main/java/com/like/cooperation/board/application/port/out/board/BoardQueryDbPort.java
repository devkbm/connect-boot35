package com.like.cooperation.board.application.port.out.board;

import java.util.List;

import com.like.cooperation.board.application.port.in.board.query.BoardHierarchy;
import com.like.cooperation.board.application.port.in.board.query.BoardQueryDTO;
import com.like.cooperation.board.application.port.in.board.query.BoardQueryResultDTO;

public interface BoardQueryDbPort {
	
	List<BoardQueryResultDTO> selectList(BoardQueryDTO dto);
	
	List<BoardHierarchy> selectHierarchy();
}
