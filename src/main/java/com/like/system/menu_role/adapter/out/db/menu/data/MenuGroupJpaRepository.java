package com.like.system.menu_role.adapter.out.db.menu.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu.MenuGroupId;

public interface MenuGroupJpaRepository extends JpaRepository<MenuGroup, MenuGroupId>, ListQuerydslPredicateExecutor<MenuGroup> {

}
