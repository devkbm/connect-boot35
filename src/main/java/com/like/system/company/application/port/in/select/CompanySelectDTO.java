package com.like.system.company.application.port.in.select;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record CompanySelectDTO(
		String clientAppUrl,
		String companyCode,
		String companyName,
		String businessRegistrationNumber,
		String coporationNumber,
		String nameOfRepresentative,
		LocalDate establishmentDate
		) {
}
