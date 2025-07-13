package com.like.cooperation.todo.application.port.in.group;

import com.like.cooperation.todo.domain.TodoGroup;

public interface TodoGroupCreateUseCase {

	TodoGroup create(String userId);
}
