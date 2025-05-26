package com.like.system.company.application.dto;

import com.like.system.company.domain.CompanyInfo;

public class CompanyInfoSaveDTOMapper {

	public static CompanyInfo toEntity(CompanyInfoSaveDTO dto) {
		return new CompanyInfo(
				dto.clientAppUrl(),
				dto.companyCode(),
				dto.companyName(),
				dto.businessRegistrationNumber(),
				dto.coporationNumber(),
				dto.nameOfRepresentative(),
				dto.establishmentDate()
				);
	}
	
	public static CompanyInfoSaveDTO toDTO(CompanyInfo entity) {		
		
		return CompanyInfoSaveDTO
				.builder()
				.companyCode(entity.getId().getCompanyCode())
				.companyName(entity.getCompanyName())
				.businessRegistrationNumber(entity.getBusinessRegistrationNumber())
				.coporationNumber(entity.getCoporationNumber())
				.nameOfRepresentative(entity.getNameOfRepresentative())
				.establishmentDate(entity.getEstablishmentDate())
				.build();
					
	}
}
