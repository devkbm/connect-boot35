package com.like.system.menu_role.adapter.out.db.role.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.like.system.menu_role.domain.role.Role;

import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
	componentModel = ComponentModel.SPRING,
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface RoleEntityMapper {

	RoleEntityMapper INSTANCE = Mappers.getMapper(RoleEntityMapper.class);
	
	Role toEntity(RoleJpaEntity jpaEntity);
		
	RoleJpaEntity toJpaEntity(Role entity);
	
}
