package com.like.system.company.application.port.in.save;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record CompanySaveDTO(
		String clientAppUrl,
		String companyCode,
		String companyName,
		String businessRegistrationNumber,
		String coporationNumber,
		String nameOfRepresentative,
		LocalDate establishmentDate
		) {
}
