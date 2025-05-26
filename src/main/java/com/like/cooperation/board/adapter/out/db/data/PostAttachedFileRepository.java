package com.like.cooperation.board.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.cooperation.board.domain.post.PostAttachedFile;

public interface PostAttachedFileRepository extends JpaRepository<PostAttachedFile, Long>, ListQuerydslPredicateExecutor<PostAttachedFile> {

}
