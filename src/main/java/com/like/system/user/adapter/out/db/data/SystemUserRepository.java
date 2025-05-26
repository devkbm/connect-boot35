package com.like.system.user.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserId;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, SystemUserId>,
											  RevisionRepository<SystemUser, SystemUserId, Long>,
											  ListQuerydslPredicateExecutor<SystemUser> {

}
