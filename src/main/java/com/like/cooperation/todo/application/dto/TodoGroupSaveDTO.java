package com.like.cooperation.todo.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.like.cooperation.todo.domain.TodoGroup;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TodoGroupSaveDTO(			
		String clientAppUrl,
		String companyCode,
		String pkTodoGroup,
		String todoGroupName
		) {
	
	public void modifyEntity(TodoGroup entity) {
		entity.modify(todoGroupName);
	}
}