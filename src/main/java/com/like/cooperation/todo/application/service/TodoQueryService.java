package com.like.cooperation.todo.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.application.port.in.todo.TodoQueryResultDTO;
import com.like.cooperation.todo.application.port.in.todo.TodoQueryUseCase;
import com.like.cooperation.todo.application.port.out.TodoQueryDbPort;

@Transactional(readOnly=true)
@Service
public class TodoQueryService implements TodoQueryUseCase {

	TodoQueryDbPort dbPort;
	
	TodoQueryService(TodoQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<TodoQueryResultDTO> select(Long todoGroupId) {					
		return this.dbPort.select(todoGroupId);
	}

	
}
