package com.like.system.company.application.port.in.query;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record CompanyQueryResultDTO(
		String clientAppUrl,
		String companyCode,
		String companyName,
		String businessRegistrationNumber,
		String coporationNumber,
		String nameOfRepresentative,
		LocalDate establishmentDate
		) {
}
