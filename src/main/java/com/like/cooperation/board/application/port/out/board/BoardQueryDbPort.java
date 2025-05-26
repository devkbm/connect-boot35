package com.like.cooperation.board.application.port.out.board;

import java.util.List;

import com.like.cooperation.board.application.dto.board.BoardHierarchy;
import com.like.cooperation.board.application.dto.board.BoardQueryDTO;
import com.like.cooperation.board.application.dto.board.BoardSaveDTO;

public interface BoardQueryDbPort {
	
	List<BoardSaveDTO> selectList(BoardQueryDTO dto);
	
	List<BoardHierarchy> selectHierarchy();
}
