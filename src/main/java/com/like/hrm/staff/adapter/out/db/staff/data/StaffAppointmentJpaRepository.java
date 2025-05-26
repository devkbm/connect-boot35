package com.like.hrm.staff.adapter.out.db.staff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecordId;

public interface StaffAppointmentJpaRepository extends JpaRepository<AppointmentRecord, AppointmentRecordId>, QuerydslPredicateExecutor<AppointmentRecord> {

}
