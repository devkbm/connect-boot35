package com.like.hrm.staff.application.dto.staff.contact;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record ContactInfoFormDTO(
		String clientAppUrl,
		String companyCode,			
		@NotEmpty String staffNo,
		String type,		
		String home_address_type,
		String home_post_number,
		String home_main_address,
		String home_sub_address,
		String extensionNumber,
		String mobileNumber
		) {

}
