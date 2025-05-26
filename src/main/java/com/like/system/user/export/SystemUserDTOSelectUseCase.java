package com.like.system.user.export;

import java.util.List;

public interface SystemUserDTOSelectUseCase {
	SystemUserDTO findUser(String userId, String companyCode);	
	
	List<SystemUserDTO> findUsers(List<String> userId, String companyCode);
}
