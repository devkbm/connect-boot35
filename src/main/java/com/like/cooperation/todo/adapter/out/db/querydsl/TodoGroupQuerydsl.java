package com.like.cooperation.todo.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.todo.application.port.in.group.TodoGroupQueryResultDTO;
import com.like.cooperation.todo.domain.QTodoGroup;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class TodoGroupQuerydsl {

	final QTodoGroup qTodoGroup = QTodoGroup.todoGroup;
	
	JPAQueryFactory queryFactory;

	TodoGroupQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<TodoGroupQueryResultDTO> select(String userId) {
		
		return this.queryFactory
				.select(
					Projections.fields(
						TodoGroupQueryResultDTO.class,
						qTodoGroup.groupId.stringValue().as("groupId"),						
						qTodoGroup.todoGroupName
					)					
				)
				.from(qTodoGroup)
				.where(qTodoGroup.userId.eq(userId))
				.fetch();							
	}
}
