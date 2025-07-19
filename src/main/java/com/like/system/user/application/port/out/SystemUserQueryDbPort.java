package com.like.system.user.application.port.out;

import java.util.List;

import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO2;
import com.like.system.user.domain.SystemUser;

public interface SystemUserQueryDbPort {
	List<SystemUser> selectList(SystemUserQueryDTO dto);
	
	List<SystemUserQueryResultDTO2> selectList2(SystemUserQueryDTO dto);
}
