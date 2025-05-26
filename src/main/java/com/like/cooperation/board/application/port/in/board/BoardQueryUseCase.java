package com.like.cooperation.board.application.port.in.board;

import java.util.List;

import com.like.cooperation.board.application.dto.board.BoardHierarchy;
import com.like.cooperation.board.application.dto.board.BoardQueryDTO;
import com.like.cooperation.board.application.dto.board.BoardSaveDTO;

public interface BoardQueryUseCase {	
	
	List<BoardSaveDTO> selectList(BoardQueryDTO dto);
	
	List<BoardHierarchy> selectHierarchy();
}
