package com.like.system.menu_role.application.port.out.role;

import java.util.List;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.application.dto.role.RoleQueryDTO;

public interface RoleQueryDbPort {

	/**
	 * 전체 권한 도메인 리스트를 조회한다.
	 * @return	권한 도메인 리스트
	 */
	List<RoleJpaEntity> getRoleList(RoleQueryDTO dto);
	
}
