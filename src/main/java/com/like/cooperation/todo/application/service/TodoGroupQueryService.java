package com.like.cooperation.todo.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.application.port.in.group.TodoGroupQueryResultDTO;
import com.like.cooperation.todo.application.port.in.group.TodoGroupQueryUseCase;
import com.like.cooperation.todo.application.port.out.TodoGroupQueryDbPort;

@Transactional(readOnly=true)
@Service
public class TodoGroupQueryService implements TodoGroupQueryUseCase {
	
	TodoGroupQueryDbPort dbPort;
	
	TodoGroupQueryService(TodoGroupQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}			

	@Override
	public List<TodoGroupQueryResultDTO> select(String userId) {			
		return this.dbPort.select(userId);
	}
		
}
