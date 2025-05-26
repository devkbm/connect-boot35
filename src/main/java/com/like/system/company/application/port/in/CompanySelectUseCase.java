package com.like.system.company.application.port.in;

import com.like.system.company.application.dto.CompanyInfoSaveDTO;

import jakarta.annotation.Nullable;

public interface CompanySelectUseCase {
	@Nullable CompanyInfoSaveDTO select(String companyCode);
}
