package com.like.system.menu_role.application.port.in.menu.query;

import jakarta.validation.constraints.NotEmpty;

public record MenuQueryDTO(
		String companyCode,
		@NotEmpty(message = "필수 입력 값입니다.")
		String menuGroupCode,
		String menuCode,
		String menuName
		) {

}
