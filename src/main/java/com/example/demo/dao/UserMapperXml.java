package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.UserEntity;

public interface UserMapperXml {
	
	List<UserEntity> getAll();
	
	Integer getMaxId();

	UserEntity getOne(Long id);
	
	UserEntity getOneByEntry(UserEntity user);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);
}
