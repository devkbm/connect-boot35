package com.like.cooperation.todo.application.port.in.todo;

import java.time.LocalDate;

import com.like.cooperation.todo.domain.Todo;
import com.like.cooperation.todo.domain.TodoGroup;

import lombok.Builder;

@Builder
public record TodoSaveDTO(
		String clientAppUrl,
		String companyCode,
		String groupId,
		String todoId,
		String todo,		
		Boolean completed,
		LocalDate dueDate,
		String comments
		) {
	
	public Todo newEntity(TodoGroup todoGroup) {
		Todo entity = Todo.builder()
						  .todoGroup(todoGroup)
						  .todo(todo)
						  .dueDate(dueDate)
						  .comments(comments)
						  .build();
		
		entity.setAppUrl(clientAppUrl);
		
		return entity;	
	}
	
	public void modifyEntity(Todo entity) {
		entity.modify(todo, completed, dueDate, comments);
		
		entity.setAppUrl(clientAppUrl);
	}
	
	public static TodoSaveDTO toDTO(Todo entity) {		
		return TodoSaveDTO.builder()
				       .groupId(entity.getTodoGroup().getGroupId().toString())
				       .todoId(entity.getTodoId().toString())
				       .todo(entity.getTodo())
				       .completed(entity.isCompleted())
				       .dueDate(entity.getDueDate())
				       .comments(entity.getComments())
					   .build();	
	}
}