package com.like.hrm.hrmcode.adapter.out.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.domain.HrmCodeType;

@Repository
public interface HrmCodeTypeRepository extends JpaRepository<HrmCodeType, String> {

}
