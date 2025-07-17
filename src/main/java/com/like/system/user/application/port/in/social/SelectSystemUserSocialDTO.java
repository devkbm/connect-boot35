package com.like.system.user.application.port.in.social;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SelectSystemUserSocialDTO {

	String userId;
	
	String name;
	
	String email;
	
	LocalDateTime createdDt;
	
	Boolean useYn;
}
