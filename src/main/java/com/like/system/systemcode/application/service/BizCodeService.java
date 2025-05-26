package com.like.system.systemcode.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.systemcode.adapter.out.db.data.BizCodeRepository;
import com.like.system.systemcode.adapter.out.db.data.BizCodeTypeJpaRepository;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCode;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCodeId;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCodeType;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCodeTypeId;
import com.like.system.systemcode.application.dto.BizCodeDTO;

@Service
@Transactional
public class BizCodeService {

	private BizCodeRepository repository;
	private BizCodeTypeJpaRepository bizTypeRepository;
	
	public BizCodeService(BizCodeRepository repository
						 ,BizCodeTypeJpaRepository bizTypeRepository) {
		this.repository = repository;
		this.bizTypeRepository = bizTypeRepository;
	}		
	
	public JpaBizCode getBizCode(String companyCode, String typeId, String code) {				
		return repository.findById(new JpaBizCodeId(companyCode, typeId, code)).orElse(null);
	}
	
	public void saveBizCode(BizCodeDTO.Form dto) {	
		JpaBizCodeType bizType = this.bizTypeRepository.findById(new JpaBizCodeTypeId(dto.companyCode(), dto.typeId()))
													.orElseThrow(() -> new IllegalArgumentException("업무코드분류는 필수 값입니다."));
		JpaBizCode entity = this.getBizCode(dto.companyCode(), dto.typeId(), dto.code());
					
		if (entity == null) {			
			entity = dto.newEntity(bizType);			
		} else {
			dto.modify(entity);
		}
		
		repository.save(entity);
	}
	
	public void deleteBizCode(String companyCode, String typeId, String code) {
		repository.deleteById(new JpaBizCodeId(companyCode, typeId, code));		
	}
	
}
