package com.like.hrm.staff.domain.staff.appointment;

import java.util.Arrays;

import com.like.common.enums.AbstractEnumCodeConverter;
import com.like.common.enums.EnumCode;

import lombok.Getter;

@Getter
public enum AppointmentApplyType implements EnumCode<String> {
	RESERVATION("10", "예약적용"),
	DIRECTLY("02", "즉시적용")
	;
	
	private String code;
	private String description;
	
	AppointmentApplyType(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	
	public static AppointmentApplyType of(String code) {	
		return Arrays.stream(AppointmentApplyType.values())
                	 .filter( t -> t.getCode().equals(code))
                	 .findAny().orElse(null);
	}
	
	
	@jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractEnumCodeConverter<AppointmentApplyType, String> {
        public Converter() {
            super(AppointmentApplyType.class);
        }
    }
	
}
