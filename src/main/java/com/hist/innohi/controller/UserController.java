package com.hist.innohi.controller;

import com.hist.innohi.dto.ResponseDTO;
import com.hist.innohi.model.StartUpEntity;
import com.hist.innohi.model.UserEntity;
import com.hist.innohi.service.StartupService;
import com.hist.innohi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	private UserService service;
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link StartupService}
	 * 
	 */
	
	@GetMapping(value="/findUser", produces="application/json; charset=UTF-8")
	public HttpEntity<?> selectStartup(@RequestParam(required=true) String loginId)  throws Exception {
		List<UserEntity> res = service.selectUserService(loginId);
		ResponseDTO<UserEntity> response = ResponseDTO.<UserEntity>builder().data(res).successYn(true).build();
		return ResponseEntity.ok().body(response);
	}
}
