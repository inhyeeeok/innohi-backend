
package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	private StartUpsRepository startupRepo;
	
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
	
	public List<StartUpsEntity> selectStartupService(HashMap<String, Object> paramData, Integer offset, Integer limit) throws Exception {
		List<StartUpsEntity> entity = null;
		//PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("name")));

		if(paramData == null){
			entity = startupRepo.findAll();
		}else{
		//	Pageable pageWithElements = PageRequest.of(offset, limit, Sort.by("no"));
			Pageable pageWithElements = PageRequest.of(0, 10, Sort.by("no"));
			entity = startupRepo.findAllBycategory("의료", pageWithElements);
		}
		return entity;
	}
	
//	private Sort orderByNoAsc(){
//		return new Sort(Sort.Direction.ASC, "id")
//                .and(new Sort(Sort.Direction.ASC, "name"));
//	}
	
	
	public HashMap<String, Object> selectMemberService2() throws Exception {
		return null;
	}
}
