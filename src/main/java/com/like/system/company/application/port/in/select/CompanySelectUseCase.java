package com.like.system.company.application.port.in.select;

import jakarta.annotation.Nullable;

public interface CompanySelectUseCase {
	@Nullable CompanySelectDTO select(String companyCode);
}
