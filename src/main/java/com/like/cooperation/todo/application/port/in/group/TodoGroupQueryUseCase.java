package com.like.cooperation.todo.application.port.in.group;

import java.util.List;

public interface TodoGroupQueryUseCase {

	List<TodoGroupQueryResultDTO> select(String userId);
}
