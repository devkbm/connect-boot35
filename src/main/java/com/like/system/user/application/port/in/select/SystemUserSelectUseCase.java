package com.like.system.user.application.port.in.select;

public interface SystemUserSelectUseCase {
	SystemUserSelectDTO selectDTO(String userId, String companyCode);	
}
