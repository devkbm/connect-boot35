package com.like.hrm.staff.application.port.in.staff.contact.select;

import java.util.Optional;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.contact.ContactInfo;

public class StaffContactSelectDTOMapper {
		
	public static StaffContactSelectDTO toDTO(Staff staff) {
	
		Optional<ContactInfo> home = staff.getContactInfoList().get("A1");		
		Optional<ContactInfo> extensionNumber = staff.getContactInfoList().get("P1");		
		Optional<ContactInfo> mobileNumber = staff.getContactInfoList().get("P2");
		
							
		return StaffContactSelectDTO.builder()
				  .companyCode(staff.getId().companyCode())	
		 		  .staffNo(staff.getId().staffNo())
		 		  .homeAddressType(home.map(ContactInfo::getAddress).map(Address::getAddress_type).orElse(null))
		 		  .homePostNumber(home.map(ContactInfo::getAddress).map(Address::getPost_number).orElse(null))
		 		  .homeMainAddress(home.map(ContactInfo::getAddress).map(Address::getMain_address).orElse(null))
		 		  .homeSubAddress(home.map(ContactInfo::getAddress).map(Address::getSub_address).orElse(null))
		 		  .extensionNumber(extensionNumber.map(ContactInfo::getPhoneNumber).map(PhoneNumber::getNumber).orElse(null))
		 		  .mobileNumber(mobileNumber.map(ContactInfo::getPhoneNumber).map(PhoneNumber::getNumber).orElse(null))		 		  					 		  					 		  					 		  				
				  .build();
	}
}
