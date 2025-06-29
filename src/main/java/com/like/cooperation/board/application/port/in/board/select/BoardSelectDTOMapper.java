package com.like.cooperation.board.application.port.in.board.select;

import java.util.Optional;

import com.like.cooperation.board.domain.board.Board;

public class BoardSelectDTOMapper {

	public static BoardSelectDTO toDTO(Board entity) {							
		
		if (entity == null)
			return null;
		
		Optional<Board> parent = Optional.ofNullable(entity.getParent());			
		
		return BoardSelectDTO.builder()
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
		
}
