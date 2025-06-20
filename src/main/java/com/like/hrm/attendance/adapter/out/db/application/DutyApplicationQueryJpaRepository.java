package com.like.hrm.attendance.adapter.out.db.application;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.attendance.domain.application.AttendanceApplication;
import com.like.hrm.attendance.domain.code.WorkChangeCode;
//import com.like.hrm.workchangeapp.domain.QWorkChangeApplication;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class DutyApplicationQueryJpaRepository implements DutyApplicationQueryRepository {

	private JPAQueryFactory	queryFactory;
	
	public DutyApplicationQueryJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	//@Override
	//public List<AttendanceApplication> getDutyApplicationList(DutyApplicationDTO.Search condition) {
//		return null;
		/*
		return queryFactory
				.selectFrom(QWorkChangeApplication.workChangeApplication)
				.where(condition.getBooleanBuilder())
				.fetch();*/
	//}

	@Override
	public long getDutyApplicationCount(String staffId, List<WorkChangeCode> dutyCodeList, LocalDate fromDate,
			LocalDate toDate) {
		
		return 0L;
		/*
		QWorkChangeApplication qDutyApplication = QWorkChangeApplication.workChangeApplication;							
		List<String> dutyCodes = dutyCodeList.stream().map(e -> e.getDutyCode()).toList();
				
		return queryFactory
				.selectFrom(QWorkChangeApplication.workChangeApplication)
				.where(qDutyApplication.staffId.eq(staffId)
				  .and(qDutyApplication.dutyCode.in(dutyCodes)))
				.fetch()
				.size();
				*/				
	}

}
