
package com.hist.innohi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hist.innohi.model.StartUpEntity;
import com.hist.innohi.model.TodoEntity;
import com.hist.innohi.persistence.StartUpRepository;
import com.hist.innohi.persistence.TodoRepository;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

@Slf4j
@Service
public class StartupService {

	@Autowired
	private StartUpRepository startupRepo;
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link StartupService}
	 * 
	 */
	
	public List<StartUpEntity> selectStartupService(String key, String value, Integer offset, Integer limit) {
		List<StartUpEntity> entity = null;
		//PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("name")));
		Pageable pageWithElements = PageRequest.of(offset, limit, Sort.by("no", key));

		if(key.equals("category")){
			entity = startupRepo.findAllBycategory(value, pageWithElements);
			
		}else if(key.equals("techType")){
			entity = startupRepo.findAllBytechType(value, pageWithElements);
		}
		return entity;
	}
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link StartupService}
	 * 
	 */
	
	public List<StartUpEntity> selectAllStartupService(String keyword, Integer offset, Integer limit) throws Exception {
		List<StartUpEntity> entity = null;
		Pageable pageWithElements = PageRequest.of(offset, limit, Sort.by(keyword, "no"));
		
		Page<StartUpEntity> pageEntity = startupRepo.findAll(pageWithElements);
		entity = pageEntity.getContent();

		return entity;
	}
	
	/**
	 * @author ihhyeok
	 * @param param 
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link StartupService}
	 * 
	 */
	
	@Transactional
	public List<StartUpEntity> insertStartupService(StartUpEntity param) {
		startupRepo.save(param);
		
		return startupRepo.findByno(param.getNo());
	}
}
