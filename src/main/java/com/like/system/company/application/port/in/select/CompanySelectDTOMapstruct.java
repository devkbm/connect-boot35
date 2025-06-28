package com.like.system.company.application.port.in.select;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.like.system.company.domain.CompanyInfo;

@Mapper(
	componentModel = ComponentModel.SPRING,
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CompanySelectDTOMapstruct {
	
	CompanySelectDTOMapstruct INSTANCE = Mappers.getMapper( CompanySelectDTOMapstruct.class ); 

	@Mapping(target = "companyCode", source = "id.companyCode")
	@Mapping(target = "clientAppUrl", ignore = true)
	CompanySelectDTO toDTO(CompanyInfo entity);
}
