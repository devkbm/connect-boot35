package com.like.cooperation.todo.application.port.in.todo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoQueryResultDTO {
		String clientAppUrl;		
		String groupId;
		String todoId;
		String todo;
		boolean isCompleted;
		LocalDate dueDate;
		String comments;

}