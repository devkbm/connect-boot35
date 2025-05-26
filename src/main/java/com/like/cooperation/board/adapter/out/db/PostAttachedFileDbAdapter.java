package com.like.cooperation.board.adapter.out.db;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.PostAttachedFileRepository;
import com.like.cooperation.board.adapter.out.db.querydsl.PostAttachedFileQuerydsl;
import com.like.cooperation.board.application.port.out.post.PostAttachedFileDbPort;
import com.like.cooperation.board.domain.post.PostAttachedFile;

@Repository
public class PostAttachedFileDbAdapter implements PostAttachedFileDbPort {

	PostAttachedFileRepository repository;
	
	PostAttachedFileQuerydsl querydsl;
	
	PostAttachedFileDbAdapter(PostAttachedFileRepository repository, PostAttachedFileQuerydsl querydsl) {
		this.repository = repository;
		this.querydsl = querydsl;
	}
	
	@Override
	public Optional<PostAttachedFile> select(Long postFileId) {
		return this.repository.findById(postFileId);
	}
	
	@Override
	public void save(List<PostAttachedFile> files) {
		this.repository.saveAll(files);
	}
	
	@Override
	public void delete(Long postFileId) {
		this.repository.deleteById(postFileId);		
	}

	@Override
	public void deleteNotMatched(List<PostAttachedFile> files) {
		this.querydsl.deleteNotMatched(files);		
	}

	@Override
	public void deleteAll(Long postId) {
		this.querydsl.deleteAll(postId);		
	}

	

	

}
