package com.like.common.enums;

import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.AttributeConverter;

// https://medium.com/@rnrghks09/jpa-entity-enum-converter%EB%A5%BC-%EC%A2%80-%EB%8D%94-%EC%9C%A0%EC%97%B0%ED%95%98%EA%B2%8C-%EA%B4%80%EB%A6%AC%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95-32e952fba28e
public abstract class AbstractEnumCodeConverter<T extends Enum<T> & EnumCode<E>, E> implements AttributeConverter<T, E> {

    private final Class<T> clazz;

    public AbstractEnumCodeConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E convertToDatabaseColumn(T attribute) { 
    	if (Objects.isNull(attribute)) return null;
    	
        return attribute.getCode();
    }

    @Override
    public T convertToEntityAttribute(E dbData) {
        if (Objects.isNull(dbData)) return null;  
            
        
        return Arrays.stream(clazz.getEnumConstants())
		             .filter(e -> e.getCode().equals(dbData))
		             .findFirst()
		             .orElseThrow(() -> new IllegalArgumentException("Unknown code: " + dbData));
    }
}
