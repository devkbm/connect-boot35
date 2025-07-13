package com.like.cooperation.todo.application.port.in.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoGroupQueryResultDTO {				
	String groupId;
	String todoGroupName;			
}