package com.like.system.file.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.file.adapter.out.db.jpa.FileInfoJpaRepository;
import com.like.system.file.application.port.out.FileInfoCommandDbPort;
import com.like.system.file.domain.FileInfo;

@Repository
public class FileInfoCommandDbAdapter implements FileInfoCommandDbPort  {

	FileInfoJpaRepository repository;
	
	FileInfoCommandDbAdapter(FileInfoJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public FileInfo getFileInfo(String id) {
		return this.repository.findById(Long.parseLong(id)).orElse(null);
	}
	
	@Override
	public List<FileInfo> getFileInfo(List<String> ids) {		
		return this.repository.findAllById(ids.stream().map(e -> Long.parseLong(e)).toList()); 
	}

	@Override
	public FileInfo save(FileInfo entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<FileInfo> save(List<FileInfo> entities) {
		return this.repository.saveAll(entities);
	}
	
	@Override
	public void delete(String id) {
		this.repository.deleteById(Long.parseLong(id));
	}

}
