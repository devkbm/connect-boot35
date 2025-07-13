package com.like.cooperation.todo.application.port.in.todo;

import java.util.List;

public interface TodoQueryUseCase {
	
	List<TodoQueryResultDTO> select(Long todoGroupId);
}
