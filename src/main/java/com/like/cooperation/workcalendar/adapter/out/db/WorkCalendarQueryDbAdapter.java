package com.like.cooperation.workcalendar.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryResultDTO;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarQueryDbPort;
import com.like.cooperation.workcalendar.domain.QWorkCalendar;
import com.like.cooperation.workcalendar.domain.QWorkCalendarMember;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class WorkCalendarQueryDbAdapter implements WorkCalendarQueryDbPort {
	private JPAQueryFactory queryFactory;
	private final QWorkCalendar qWorkCalendar = QWorkCalendar.workCalendar;
	private final QWorkCalendarMember qWorkCalendarMember = QWorkCalendarMember.workCalendarMember;
	
	public WorkCalendarQueryDbAdapter(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	@Override
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(WorkCalendarQueryDTO searchCondition) {
		return queryFactory
				.select(Projections.fields(
						WorkCalendarQueryResultDTO.class,
						//Expressions.asString(qWorkCalendar.id.stringValue()).as("id"),
						qWorkCalendar.id.stringValue().as("id"),
						qWorkCalendar.name,
						qWorkCalendar.color
						)
				)
				.from(qWorkCalendar)
				.where(searchCondition.getBooleanBuilder())
				.fetch();
	}

	@Override
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(String userId) {

		return queryFactory
				.select(Projections.fields(
						WorkCalendarQueryResultDTO.class,
						//Expressions.asString(qWorkCalendar.id.stringValue()).as("id"),
						qWorkCalendar.id.stringValue().as("id"),
						qWorkCalendar.name,
						qWorkCalendar.color
						)
				)
				.from(qWorkCalendar)
				.where(qWorkCalendar.id.in(
						   JPAExpressions
                           .select(qWorkCalendarMember.id.workCalendar)
                           .from(qWorkCalendarMember)
                           .where(qWorkCalendarMember.id.userId.eq(userId)))
						)
				.fetch();
		/*
		return queryFactory
				.selectFrom(qWorkCalendar)
				.join(qWorkCalendar.memberList, qWorkCalendarMember)
				.where(qWorkCalendarMember.id.userId.eq(userId))
				.fetch();
		*/
	}
	
	
}
