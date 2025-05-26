package com.like.cooperation.todo.application.port.in;

import com.like.cooperation.todo.application.dto.TodoGroupSaveDTO;

public interface TodoGroupSaveUseCase {
	void save(TodoGroupSaveDTO dto);
}
