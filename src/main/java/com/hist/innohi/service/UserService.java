
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
import com.hist.innohi.model.UserEntity;
import com.hist.innohi.persistence.StartUpRepository;
import com.hist.innohi.persistence.TodoRepository;
import com.hist.innohi.persistence.UserRepository;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link UserService}
	 * 
	 */
	
	public List<UserEntity> selectUserService(String loginId) {
		List<UserEntity> entity = userRepo.findByloginId(loginId);
		
		return entity;
	}
}
