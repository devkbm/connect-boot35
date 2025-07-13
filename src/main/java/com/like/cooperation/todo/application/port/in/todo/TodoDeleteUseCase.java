package com.like.cooperation.todo.application.port.in.todo;

public interface TodoDeleteUseCase {
	void delete(Long todoGroupId, Long todoId);
}
