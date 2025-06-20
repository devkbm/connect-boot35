package com.like.core.jpa.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeStringConverter implements AttributeConverter<LocalTime, String> {

	@Override
	public String convertToDatabaseColumn(LocalTime arg0) {
		return arg0.format(DateTimeFormatter.ofPattern("HHmm"));
	}

	@Override
	public LocalTime convertToEntityAttribute(String arg0) {		
		return LocalTime.of(
				Integer.parseInt(arg0.substring(0, 1)), 
				Integer.parseInt(arg0.substring(2, 3))
				);
	}

}
