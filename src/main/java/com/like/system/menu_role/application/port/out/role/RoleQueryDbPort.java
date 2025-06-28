package com.like.system.menu_role.application.port.out.role;

import java.util.List;

import com.like.system.menu_role.application.port.in.role.query.RoleQueryDTO;
import com.like.system.menu_role.application.port.in.role.query.RoleQueryResultDTO;

public interface RoleQueryDbPort {

	/**
	 * 전체 권한 도메인 리스트를 조회한다.
	 * @return	권한 도메인 리스트
	 */
	List<RoleQueryResultDTO> getRoleList(RoleQueryDTO dto);
	
}
