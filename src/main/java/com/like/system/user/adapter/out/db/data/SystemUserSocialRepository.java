package com.like.system.user.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.system.user.domain.oauth2.SystemUserSocialEmail;
import com.like.system.user.domain.oauth2.SystemUserSocialEmailId;

public interface SystemUserSocialRepository extends JpaRepository<SystemUserSocialEmail, SystemUserSocialEmailId>, ListQuerydslPredicateExecutor<SystemUserSocialEmail> {

}
