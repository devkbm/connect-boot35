package com.like.hrm.staff.application.port.in.staff.contact.save;

import java.util.List;
import java.util.Optional;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.contact.ContactInfo;

public class StaffContactSaveDTOMapper {

	
	public static List<ContactInfo> toEntity(Staff staff, StaffContactSaveDTO dto) {
		
		ContactInfo entity1 = new ContactInfo(
				staff, 
				"A1", 
				new Address(dto.homeAddressType(), dto.homePostNumber(), dto.homeMainAddress(), dto.homeSubAddress())
				);
		
		ContactInfo entity2 = new ContactInfo(
				staff, 
				"P1", 
				new PhoneNumber(dto.extensionNumber())
				);
		
		ContactInfo entity3 = new ContactInfo(
				staff, 
				"P2", 
				new PhoneNumber(dto.mobileNumber())
				);
		
		return List.of(entity1, entity2, entity3);
	}
	
	public static StaffContactSaveDTO toDTO(Staff staff) {
	
		Optional<ContactInfo> home = staff.getContactInfoList().get("A1");		
		Optional<ContactInfo> extensionNumber = staff.getContactInfoList().get("P1");		
		Optional<ContactInfo> mobileNumber = staff.getContactInfoList().get("P2");
		
							
		return StaffContactSaveDTO.builder()
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
