package com.like.system.menu_role.application.port.in.role;

import java.util.List;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.application.dto.role.RoleQueryDTO;

public interface RoleQueryUseCase {
	List<RoleJpaEntity> getAuthorityList(RoleQueryDTO condition);
}
