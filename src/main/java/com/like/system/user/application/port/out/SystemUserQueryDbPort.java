package com.like.system.user.application.port.out;

import java.util.List;

import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.domain.SystemUser;

public interface SystemUserQueryDbPort {
	List<SystemUser> selectList(SystemUserQueryDTO dto);
}
