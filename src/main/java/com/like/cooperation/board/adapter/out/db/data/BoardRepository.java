package com.like.cooperation.board.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.like.cooperation.board.domain.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {	
			
}