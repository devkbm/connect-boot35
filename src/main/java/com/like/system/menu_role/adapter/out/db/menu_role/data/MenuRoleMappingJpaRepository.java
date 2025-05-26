package com.like.system.menu_role.adapter.out.db.menu_role.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.system.menu_role.domain.menu_role.MenuRoleMapping;
import com.like.system.menu_role.domain.menu_role.MenuRoleMappingId;

public interface MenuRoleMappingJpaRepository extends JpaRepository<MenuRoleMapping, MenuRoleMappingId>, ListQuerydslPredicateExecutor<MenuRoleMapping> {

}
