package com.like.cooperation.todo.application.port.in;

import java.util.List;

import com.like.cooperation.todo.application.dto.TodoSaveDTO;

public interface TodoQueryUseCase {

	List<TodoSaveDTO> select(Long todoGroupId);
}
