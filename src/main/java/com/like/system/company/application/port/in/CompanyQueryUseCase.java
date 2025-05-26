package com.like.system.company.application.port.in;

import java.util.List;

import com.like.system.company.application.dto.CompanyInfoSaveDTO;

public interface CompanyQueryUseCase {

	List<CompanyInfoSaveDTO> query();
}
