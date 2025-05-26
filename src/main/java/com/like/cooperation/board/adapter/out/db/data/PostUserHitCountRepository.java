package com.like.cooperation.board.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.like.cooperation.board.domain.post.PostUserHitCount;
import com.like.cooperation.board.domain.post.PostUserHitCountId;

public interface PostUserHitCountRepository extends JpaRepository<PostUserHitCount, PostUserHitCountId> {	
}
