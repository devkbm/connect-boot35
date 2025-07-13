package com.like.cooperation.todo.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.todo.adapter.out.db.querydsl.TodoQuerydsl;
import com.like.cooperation.todo.application.port.in.todo.TodoQueryResultDTO;
import com.like.cooperation.todo.application.port.out.TodoQueryDbPort;

@Repository
public class TodoQueryDbAdapter implements TodoQueryDbPort {

	TodoQuerydsl repository;
	
	TodoQueryDbAdapter(TodoQuerydsl repository) {
		this.repository = repository;
	}

	@Override
	public List<TodoQueryResultDTO> select(Long todoGroupId) {
		return this.repository.select(todoGroupId);
	}
}
