package com.like.system.systemcode.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.systemcode.adapter.out.db.entity.QJpaBizCodeType;
import com.like.system.systemcode.application.port.in.query.BizCodeTypeQueryResultDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BizCodeTypeQueryJpaRepository {

	private JPAQueryFactory	queryFactory;
	private static final QJpaBizCodeType qBizCodeType = QJpaBizCodeType.jpaBizCodeType;
		
	public BizCodeTypeQueryJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
		
	public List<BizCodeTypeQueryResultDTO> getList(String organizactionCode) {	
		return queryFactory
				.select(Projections.fields(
						BizCodeTypeQueryResultDTO.class,
						qBizCodeType.modifiedAppUrl.as("clientAppUrl"),
						qBizCodeType.id.companyCode.as("companyCode"),
						qBizCodeType.id.typeId,
						qBizCodeType.name.as("typeName"),
						qBizCodeType.sequence,
						qBizCodeType.bizType.stringValue().as("bizType"),
						qBizCodeType.comment						
						)
				)
				.from(qBizCodeType)
				.where(qBizCodeType.id.companyCode.eq(organizactionCode))				  
				.fetch();
	}

}
