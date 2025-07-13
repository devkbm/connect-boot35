package com.like.cooperation.todo.application.port.out;

import java.util.List;

import com.like.cooperation.todo.application.port.in.group.TodoGroupQueryResultDTO;

public interface TodoGroupQueryDbPort {

	List<TodoGroupQueryResultDTO> select(String userId);
}
