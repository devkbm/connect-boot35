package com.like.system.dept.adapter.out.db;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.dept.adapter.out.db.data.DeptJpaRepository;
import com.like.system.dept.application.port.in.query.DeptQueryDTO;
import com.like.system.dept.application.port.out.DeptQueryDbPort;
import com.like.system.dept.domain.Dept;
import com.like.system.dept.domain.QDept;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@Repository
public class DeptQueryDbAdapter implements DeptQueryDbPort {

	DeptJpaRepository repository;
		
	public DeptQueryDbAdapter(DeptJpaRepository repository) {
		this.repository = repository;
	}	
	
	@Override
	public List<Dept> select(DeptQueryDTO dto) {
		return this.repository.findAll(getCondition(dto));
	}
	
	private final QDept qType = QDept.dept;
	public BooleanBuilder getCondition(DeptQueryDTO dto) {
				
		BooleanBuilder builder = new BooleanBuilder();
		
		builder
			.and(eqOrganizationCode(dto.company()))
			.and(likeDeptCode(dto.deptCode()))
			.and(likeDeptName(dto.deptName()));
													
		return builder;
	}
	
	private BooleanExpression eqOrganizationCode(String companyCode) {
		return hasText(companyCode) ? qType.id.companyCode.eq(companyCode) : null;										
	}
			
	private BooleanExpression likeDeptCode(String deptCode) {
		return hasText(deptCode) ? qType.id.deptCode.like("%"+deptCode+"%") : null;					
	}
	
	private BooleanExpression likeDeptName(String deptName) {			
		return hasText(deptName) ? qType.deptNameKorean.like("%"+deptName+"%") : null;			
	}
	
}
