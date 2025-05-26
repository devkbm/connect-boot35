package com.like.system.systemcode.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.systemcode.adapter.out.db.data.BizCodeQueryRepository;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizCode;
import com.like.system.systemcode.adapter.out.db.entity.QJpaBizCode;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BizCodeQueryJpaRepository implements BizCodeQueryRepository {

	private JPAQueryFactory	queryFactory;
	private static final QJpaBizCode qBizCode = QJpaBizCode.jpaBizCode;
		
	public BizCodeQueryJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	@Override
	public List<JpaBizCode> getBizCodeList(String organizactionCode, String typeId) {	
		return queryFactory
				.selectFrom(qBizCode)
				.where(qBizCode.id.bizCodeTypeId.companyCode.eq(organizactionCode)
				  .and(qBizCode.id.bizCodeTypeId.typeId.eq(typeId)))
				.fetch();
	}

}
