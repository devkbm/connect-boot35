package com.like.system.systemcode.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.systemcode.adapter.out.db.querydsl.BizCodeTypeQueryJpaRepository;
import com.like.system.systemcode.application.port.in.query.BizCodeTypeQueryResultDTO;
import com.like.system.systemcode.application.port.out.BizCodeTypeQueryPort;

@Repository
public class BizCodeTypeQueryDbAdapter implements BizCodeTypeQueryPort {

	BizCodeTypeQueryJpaRepository repository;
	
	BizCodeTypeQueryDbAdapter(BizCodeTypeQueryJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<BizCodeTypeQueryResultDTO> select(String companyCode) {
		
		return this.repository.getList(companyCode);
	}
}
