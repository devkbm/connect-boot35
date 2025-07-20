package com.like.system.user.application.port.in.query;

import java.util.List;

public interface SystemUserQueryUseCase {	
	List<SystemUserQueryResultDTO> selectList(SystemUserQueryDTO dto);
}
