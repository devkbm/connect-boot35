package com.like.cooperation.todo.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.application.port.in.group.TodoGroupSaveDTO;
import com.like.cooperation.todo.application.port.in.group.TodoGroupSaveUseCase;
import com.like.cooperation.todo.application.port.out.TodoGroupCommandDbPort;
import com.like.cooperation.todo.domain.TodoGroup;

@Transactional
@Service
public class TodoGroupSaveService implements TodoGroupSaveUseCase {

	TodoGroupCommandDbPort dbPort;
	
	TodoGroupSaveService(TodoGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(TodoGroupSaveDTO dto) {
		TodoGroup entity = dbPort.select(Long.parseLong(dto.groupId()));
		
		entity.modify(dto.todoGroupName());
		
		dbPort.save(entity);
	}

}
