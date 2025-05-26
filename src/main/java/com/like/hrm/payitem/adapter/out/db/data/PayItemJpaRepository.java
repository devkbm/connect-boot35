package com.like.hrm.payitem.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.payitem.domain.PayItem;
import com.like.hrm.payitem.domain.PayItemId;

public interface PayItemJpaRepository extends JpaRepository<PayItem, PayItemId>, QuerydslPredicateExecutor<PayItem> {

}
