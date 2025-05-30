package com.like.system.user.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.system.user.domain.oauth2.SystemUserSocial;
import com.like.system.user.domain.oauth2.SystemUserSocialId;

public interface SystemUserSocialRepository extends JpaRepository<SystemUserSocial, SystemUserSocialId>, ListQuerydslPredicateExecutor<SystemUserSocial> {

}
