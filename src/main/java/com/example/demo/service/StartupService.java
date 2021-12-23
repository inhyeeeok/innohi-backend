
package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StartUpsEntity;
import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.StartUpsRepository;
import com.example.demo.persistence.TodoRepository;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class StartupService {

	@Autowired
	private StartUpsRepository strepository;

//	public HashMap<String, Object> testStartupService(StartUpsEntity data) {
//		// TodoEntity 생성
//		StartUpsEntity entity = StartUpsEntity.builder().sName(data.getSName()).sCategory(data.getSCategory()).sTechType(data.getSTechType()).build();
//		// TodoEntity 저장
//		System.out.println("entity? "+entity.toString());
//		System.out.println("test1 :"+entity.getSNo());
//		strepository.save(entity);
//		System.out.println("test2 :"+entity.getSNo());
//		return entity;
//	}
	
	public List<StartUpsEntity> selectMemberService() throws Exception {
		List<StartUpsEntity> entity = strepository.findAll();
		return entity;
	}
	
	public HashMap<String, Object> selectMemberService2() throws Exception {
		return null;
	}
}
