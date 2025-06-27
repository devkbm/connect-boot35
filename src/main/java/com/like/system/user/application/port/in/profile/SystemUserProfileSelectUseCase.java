package com.like.system.user.application.port.in.profile;

public interface SystemUserProfileSelectUseCase {

	SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto);
}
