package com.like.hrm.staff.application.port.in.staff.contact.select;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StaffContactSelectDTO(
		String clientAppUrl,
		String companyCode,						
		@NotEmpty String staffNo,
		String staffName,
		String homeAddressType,
		String homePostNumber,
		String homeMainAddress,
		String homeSubAddress,
		String extensionNumber,
		String mobileNumber
		) {
		
}