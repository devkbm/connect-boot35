package com.like.system.systemcode.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.systemcode.adapter.out.db.data.BizCodeTypeJpaRepository;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCodeType;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCodeTypeId;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCodeTypeMapper;
import com.like.system.systemcode.application.port.out.BizCodeTypeCommandDbPort;
import com.like.system.systemcode.domain.BizCodeType;

@Repository
@Transactional
public class BizCodeTypeAdapter implements BizCodeTypeCommandDbPort {

	BizCodeTypeJpaRepository repository;
	
	public BizCodeTypeAdapter(BizCodeTypeJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<BizCodeType> select(String companyCode, String typeId) {
		JpaBizCodeType jpaEntity = this.repository.findById(new JpaBizCodeTypeId(companyCode, typeId)).orElse(null);
		
		return Optional.ofNullable(JpaBizCodeTypeMapper.toDomainEntity(jpaEntity));
	}	
	
	@Override
	public void Save(BizCodeType entity) {
		this.repository.save(JpaBizCodeTypeMapper.toJPAEntity(entity));		
	}
	
	@Override
	public void delete(String companyCode, String typeId) {
		this.repository.deleteById(new JpaBizCodeTypeId(companyCode, typeId));		
	}
	
}
