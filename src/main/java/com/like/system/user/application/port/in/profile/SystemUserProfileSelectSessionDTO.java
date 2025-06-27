package com.like.system.user.application.port.in.profile;

import java.util.Date;

public record SystemUserProfileSelectSessionDTO(
		String ipAddress,
		Date lastAccessedTime) {

}
