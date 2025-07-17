package com.like.core.security.oauth2.social;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialLoginRepository extends JpaRepository<SocialLogin, SocialLoginID>, ListQuerydslPredicateExecutor<SocialLogin> {

}
