package com.like.system.company.application.port.in.save;

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
public interface CompanySaveDTOMapstruct {
	
	CompanySaveDTOMapstruct INSTANCE = Mappers.getMapper( CompanySaveDTOMapstruct.class ); 

	@Mapping(target = "id", source = "companyCode")
	@Mapping(target = "appUrl", ignore = true)
	CompanyInfo toEntity(CompanySaveDTO dto);
	
	
	@Mapping(target = "companyCode", source = "id.companyCode")
	@Mapping(target = "clientAppUrl", ignore = true)
	CompanySaveDTO toDTO(CompanyInfo entity);
}
