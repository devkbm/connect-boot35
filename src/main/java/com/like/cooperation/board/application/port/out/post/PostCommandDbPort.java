package com.like.cooperation.board.application.port.out.post;

import java.util.List;
import java.util.Optional;

import com.like.cooperation.board.domain.post.Post;

public interface PostCommandDbPort {
	Optional<Post> select(Long id);
	
	void save(Post entity);	
	
	void save(List<Post> entities);
	
	void delete(Long id);
}
