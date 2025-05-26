package com.like.cooperation.board.application.port.out.post;

import java.util.List;
import java.util.Optional;

import com.like.cooperation.board.domain.post.PostAttachedFile;

public interface PostAttachedFileDbPort {
	
	Optional<PostAttachedFile> select(Long postFileId);
	
	void save(List<PostAttachedFile> files);
	
	void delete(Long postFileId);
	
	void deleteAll(Long postId);
	
	void deleteNotMatched(List<PostAttachedFile> files);
	
	
}
