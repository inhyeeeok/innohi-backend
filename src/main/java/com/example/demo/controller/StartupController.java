package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.StartUpsEntity;
import com.example.demo.service.StartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/startup")
public class StartupController {

	@Autowired
	private StartupService service;
	
//	@GetMapping("/insert")
//	public ResponseEntity<?> testStartups(StartUpsEntity data) {
//		HashMap<String, Object> str = service.testStartupService(data); // 테스트 서비스 사용
//		List<HashMap<String,Object>> list = new ArrayList<>();
//		list.add(str);
//		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
//		return str;
//	} 
	
	@GetMapping("/test2")
	public List<StartUpsEntity> testStartups2() throws Exception {
		List<StartUpsEntity> str = service.selectMemberService(); // 테스트 서비스 사용
		return str;
	}
}
