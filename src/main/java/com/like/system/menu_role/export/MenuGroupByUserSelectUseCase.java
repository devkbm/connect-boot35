package com.like.system.menu_role.export;

import java.util.List;

public interface MenuGroupByUserSelectUseCase {

	List<MenuGroupDTO> select(String userId, String companyCode);
}
