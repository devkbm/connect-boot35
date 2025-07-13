package com.like.cooperation.todo.application.port.out;

import java.util.List;

import com.like.cooperation.todo.application.port.in.todo.TodoQueryResultDTO;

public interface TodoQueryDbPort {
	List<TodoQueryResultDTO> select(Long todoGroupId);
}
