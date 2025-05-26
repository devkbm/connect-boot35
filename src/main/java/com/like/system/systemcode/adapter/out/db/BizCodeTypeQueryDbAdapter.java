package com.like.system.systemcode.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.systemcode.adapter.out.db.data.BizCodeTypeJpaRepository;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCodeType;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCodeTypeMapper;
import com.like.system.systemcode.application.dto.BizCodeTypeSaveDTO;
import com.like.system.systemcode.application.port.out.BizCodeTypeQueryPort;

@Repository
public class BizCodeTypeQueryDbAdapter implements BizCodeTypeQueryPort {

	BizCodeTypeJpaRepository repository;
	
	BizCodeTypeQueryDbAdapter(BizCodeTypeJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<BizCodeTypeSaveDTO> select(String companyCode) {
		List<JpaBizCodeType> list = this.repository.findAll();
		return list.stream().map(e -> JpaBizCodeTypeMapper.toDTO(e)).toList();
	}
}
