package com.like.cooperation.board.adapter.out.db.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.like.cooperation.board.domain.board.BoardBookmark;

public interface BoardBookmarkRepository extends JpaRepository<BoardBookmark, Long> {

	List<BoardBookmark> findByUserIdOrderBySeqAsc(String userId);
}
