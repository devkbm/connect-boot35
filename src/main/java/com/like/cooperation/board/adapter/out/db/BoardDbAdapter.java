package com.like.cooperation.board.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.BoardRepository;
import com.like.cooperation.board.application.port.out.board.BoardCommandDbPort;
import com.like.cooperation.board.domain.board.Board;

@Repository
public class BoardDbAdapter implements BoardCommandDbPort {

	BoardRepository repository;
	
	BoardDbAdapter(BoardRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Board> select(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(Board entity) {				
		this.repository.save(entity);		
	}

	@Override
	public void delete(Long boardId) {
		this.repository.deleteById(boardId);		
	}

}
