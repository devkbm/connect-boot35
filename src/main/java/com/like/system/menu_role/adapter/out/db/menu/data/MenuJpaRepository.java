package com.like.system.menu_role.adapter.out.db.menu.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuId;

public interface MenuJpaRepository extends JpaRepository<Menu, MenuId>, ListQuerydslPredicateExecutor<Menu> {

}
