package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.domain.board.QBoard;
import com.like.cooperation.board.application.port.in.board.query.BoardHierarchy;
import com.like.cooperation.board.application.port.in.board.query.BoardQueryDTO;
import com.like.cooperation.board.application.port.in.board.query.BoardQueryResultDTO;
import com.like.cooperation.board.application.port.in.board.query.QBoardHierarchy;
import com.like.cooperation.board.application.port.out.board.BoardQueryDbPort;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BoardQueryDbAdapter implements BoardQueryDbPort {

	private JPAQueryFactory queryFactory;
	private final QBoard qBoard = QBoard.board;
	
	public BoardQueryDbAdapter(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}	
	
	@Override
	public List<BoardQueryResultDTO> selectList(BoardQueryDTO dto) {
		 		
		return queryFactory				
				.select(Projections.fields(
						BoardQueryResultDTO.class,
						qBoard.modifiedAppUrl.as("clientAppUrl")
						)
				)
				.from(qBoard)
				.where(dto.getBooleanBuilder())
				.fetch();				
	}

	@Override
	public List<BoardHierarchy> selectHierarchy() {
		List<BoardHierarchy> rootList = getBoardHierarchyRootList();
		
		List<BoardHierarchy> rtn =  setLinkBoardHierarchy(rootList);
		
		return rtn;
	}

	private List<BoardHierarchy> setLinkBoardHierarchy(List<BoardHierarchy> list) {
		List<BoardHierarchy> children = null;
		
		for ( BoardHierarchy dto : list) {
			
			children = getBoardHierarchyChildrenList(Long.parseLong(dto.getKey()));
			
			if (children.isEmpty()) {	// leaf 노드이면 다음 리스트 검색
				dto.setLeaf(true);
				continue;
			} else {
				
				dto.setChildren(children);
				dto.setLeaf(false);
				
				setLinkBoardHierarchy(children);
			}
		}
		
		return list;
	}
	
	private List<BoardHierarchy> getBoardHierarchyRootList() {									
		
		/*Expression<Boolean> isLeaf = new CaseBuilder()
										.when(qBoard.ppkBoard.isNotNull()).then(true)
										.otherwise(false).as("leaf");*/	
		
		JPAQuery<BoardHierarchy> query = queryFactory
				.select(projections(qBoard))
				.from(qBoard)
				.where(qBoard.isRootNode());
													
						
		return query.fetch();	
	}
	
	private List<BoardHierarchy> getBoardHierarchyChildrenList(Long boardParentId) {
		
		JPAQuery<BoardHierarchy> query = queryFactory
				.select(projections(qBoard))
				.from(qBoard)
				.where(qBoard.parent.boardId.eq(boardParentId));								
		
		return query.fetch();
		
	}
	
	
	private QBoardHierarchy projections(QBoard qBoard) {
		return new QBoardHierarchy(
				qBoard.boardId, 
				qBoard.parent.boardId, 
				qBoard.boardType,
				qBoard.boardName, 
				qBoard.description
				);
	}
	

}
