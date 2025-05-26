/*
package com.like.hrm.staff.domain.staff.appointment;

import jakarta.persistence.AttributeConverter;

public class AppointmentApplyTypeConverter implements AttributeConverter<AppointmentApplyType, String> {

	@Override
	public String convertToDatabaseColumn(AppointmentApplyType enumValue) {
		if (enumValue == null) return null;
		
		return enumValue.getCode(); 
	}

	@Override
	public AppointmentApplyType convertToEntityAttribute(String dbCode) {
		return AppointmentApplyType.of(dbCode);		
	}

}
*/