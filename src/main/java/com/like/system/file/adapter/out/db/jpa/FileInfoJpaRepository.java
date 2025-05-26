package com.like.system.file.adapter.out.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.system.file.domain.FileInfo;

public interface FileInfoJpaRepository extends JpaRepository<FileInfo, Long>, ListQuerydslPredicateExecutor<FileInfo> {
	
}
