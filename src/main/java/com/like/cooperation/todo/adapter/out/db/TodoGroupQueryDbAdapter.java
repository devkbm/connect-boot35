package com.like.cooperation.todo.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.todo.adapter.out.db.querydsl.TodoGroupQuerydsl;
import com.like.cooperation.todo.application.port.in.group.TodoGroupQueryResultDTO;
import com.like.cooperation.todo.application.port.out.TodoGroupQueryDbPort;

@Repository
public class TodoGroupQueryDbAdapter implements TodoGroupQueryDbPort {

	TodoGroupQuerydsl repository;
	
	TodoGroupQueryDbAdapter(TodoGroupQuerydsl repository) {
		this.repository = repository;
	}

	@Override
	public List<TodoGroupQueryResultDTO> select(String userId) {		
		return this.repository.select(userId);							
	}
}
