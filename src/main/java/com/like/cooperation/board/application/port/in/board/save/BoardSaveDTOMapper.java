package com.like.cooperation.board.application.port.in.board.save;

import java.util.Optional;

import com.like.cooperation.board.domain.board.Board;
import com.like.cooperation.board.domain.board.BoardType;

public class BoardSaveDTOMapper {

	public static BoardSaveDTO toDTO(Board entity) {							
		
		if (entity == null)
			return null;
		
		Optional<Board> parent = Optional.ofNullable(entity.getParent());			
		
		return BoardSaveDTO.builder()
					    .createdDt(entity.getCreatedDt())
					    .createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
					    .modifiedDt(entity.getModifiedDt())
					    .modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())
					    .boardId(entity.getBoardId().toString())	
					    //.boardParentId(parent.map(Board::getBoardId).orElse(null))
					    .boardParentId(parent.map(e -> e.getBoardId().toString()).orElse(null))
					    .boardType(entity.getBoardType().toString())
					    .boardName(entity.getBoardName())
					    .boardDescription(entity.getDescription())						   						    
					    .useYn(entity.getUseYn())						    
					    .build();	
	}
	
	
	public static Board toEntity(BoardSaveDTO dto, Board parentBoard) {	
		Board entity = Board.builder()
							.parent(parentBoard)
							.boardId(dto.boardId() == null ? null : Long.parseLong(dto.boardId()))
							.boardType(BoardType.valueOf(dto.boardType()))
							.boardName(dto.boardName())
							.description(dto.boardDescription())
							.useYn(dto.useYn())							
							.build();	
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;					
	}	
	
	public static void modifyBoard(BoardSaveDTO dto, Board board, Board parentBoard) {
		board.modify(				
				dto.clientAppUrl(),
				parentBoard,
				BoardType.valueOf(dto.boardType()),
				dto.boardName(),
	          	dto.boardDescription(),					          
	          	dto.useYn(),
	          	dto.sequence()
				);		
	}
}
