package com.like.cooperation.todo.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.todo.application.port.in.todo.TodoQueryResultDTO;
import com.like.cooperation.todo.domain.QTodo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class TodoQuerydsl {

	final QTodo qTodo = QTodo.todo1;
	
	JPAQueryFactory queryFactory;
	
	TodoQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<TodoQueryResultDTO> select(Long todoGroupId) {
		return this.queryFactory
				.select(
					Projections.fields(
						TodoQueryResultDTO.class,
						qTodo.modifiedAppUrl.as("clientAppUrl"),						
						qTodo.todoGroup.groupId.stringValue().as("groupId"),
						qTodo.todoId.stringValue().as("todoId"),
						qTodo.todo,
						qTodo.isCompleted,
						qTodo.dueDate,
						qTodo.comments
					)					
				)
				.from(qTodo)
				.where(qTodo.todoGroup.groupId.eq(todoGroupId))
				.fetch();
	}
	
	
}
