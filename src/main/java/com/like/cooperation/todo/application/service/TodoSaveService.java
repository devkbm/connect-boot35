package com.like.cooperation.todo.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.like.cooperation.todo.application.port.in.todo.TodoSaveDTO;
import com.like.cooperation.todo.application.port.in.todo.TodoSaveUseCase;
import com.like.cooperation.todo.application.port.out.TodoGroupCommandDbPort;
import com.like.cooperation.todo.domain.Todo;
import com.like.cooperation.todo.domain.TodoGroup;

@Transactional
@Service
public class TodoSaveService implements TodoSaveUseCase {

	TodoGroupCommandDbPort dbPort;
	
	TodoSaveService(TodoGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TodoSaveDTO save(TodoSaveDTO dto) {
		
		TodoGroup todoGroup = dbPort.select(Long.parseLong(dto.groupId()));
		Todo entity = null;
		
		if (StringUtils.hasText(dto.todoId())) {
			entity = todoGroup.getTodo(Long.parseLong(dto.todoId()));
			dto.modifyEntity(entity);			
		} else {
			todoGroup.addTodo(dto.newEntity(todoGroup));
		}
					
		dbPort.save(todoGroup);			
		
		return TodoSaveDTO.toDTO(todoGroup.getLastTodo());
		
	}

}
