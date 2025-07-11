package com.like.login.application.port.in;

public interface AuthenticationTokenSelectUseCase {
	AuthenticationToken select(String userId, String companyCode, String sessionId, String ipAddress);
}
