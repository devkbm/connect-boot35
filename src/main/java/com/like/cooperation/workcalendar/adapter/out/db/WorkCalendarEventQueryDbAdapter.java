package com.like.cooperation.workcalendar.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.workcalendar.domain.WorkCalendarEvent;
import com.like.cooperation.workcalendar.adapter.out.db.querydsl.WorkCalendarEventQuerydsl;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryResultDTO;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarEventQueryDbPort;
import com.like.cooperation.workcalendar.domain.QWorkCalendarEvent;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class WorkCalendarEventQueryDbAdapter implements WorkCalendarEventQueryDbPort {
	private JPAQueryFactory queryFactory;
	private final QWorkCalendarEvent qWorkCalendarEvent = QWorkCalendarEvent.workCalendarEvent;
	
	WorkCalendarEventQuerydsl querydsl;
	
	public WorkCalendarEventQueryDbAdapter(JPAQueryFactory queryFactory, WorkCalendarEventQuerydsl querydsl) {
		this.queryFactory = queryFactory;		
		this.querydsl = querydsl;
	}
	
	@Override
	public List<WorkCalendarEvent> getScheduleList(WorkCalendarEventQueryDTO searchCondition) {
		return queryFactory
				.selectFrom(qWorkCalendarEvent)
				.where(searchCondition.getBooleanBuilder())
				.fetch();
	}

	@Override
	public List<WorkCalendarEventQueryResultDTO> getScheduleList2(WorkCalendarEventQueryDTO searchCondition) {
		return this.querydsl.getScheduleList(searchCondition);
	}
	
}
