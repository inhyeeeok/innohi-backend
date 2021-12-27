
package com.hist.innohi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hist.innohi.model.StartUpEntity;
import com.hist.innohi.model.TodoEntity;
import com.hist.innohi.persistence.StartUpRepository;
import com.hist.innohi.persistence.TodoRepository;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	@Autowired
	private StartUpRepository strepository;

	public String testService() {
		// TodoEntity 생성
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		// TodoEntity 저장
		repository.save(entity);
		// TodoEntity 검색
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		return savedEntity.getTitle();
	}
	
	public int testStartupService() {
		// TodoEntity 생성
//		StartUpsEntity entity = StartUpsEntity.builder().sName("Test").build();
		StartUpEntity entity = StartUpEntity.builder().name("Test").category("Test").techType("Test").build();
		// TodoEntity 저장
		System.out.println("test1 :"+entity.getNo());
		strepository.save(entity);
		System.out.println("test2 :"+entity.getNo());
		// TodoEntity 검색
//		StartUpsEntity savedEntity = strepository.findBysNo(entity.getSNo()).get(0);
		StartUpEntity savedEntity = strepository.findByname(entity.getName()).get(0);
		return savedEntity.getNo();
	}
	
	public List<StartUpEntity> selectMemberService() throws Exception {
		List<StartUpEntity> entity = strepository.findAll();
		return entity;
	}
	
	public HashMap<String, Object> selectMemberService2() throws Exception {
		return null;
	}
}
