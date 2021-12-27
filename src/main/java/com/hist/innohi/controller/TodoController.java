package com.hist.innohi.controller;

import com.hist.innohi.dto.ResponseDTO;
import com.hist.innohi.dto.TodoDTO;
import com.hist.innohi.model.StartUpEntity;
import com.hist.innohi.model.TodoEntity;
import com.hist.innohi.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("todo")
public class TodoController {

	@Autowired
	private TodoService service;

	@GetMapping("/test")
	public ResponseEntity<?> testTodo() {
		String str = service.testService(); // 테스트 서비스 사용
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		// ResponseEntity.ok(response) 를 사용해도 상관 없음
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/test1")
	public int testStartups() {
		int str = service.testStartupService(); // 테스트 서비스 사용
		return str;
	}
	
	@GetMapping("/test2")
	public List<StartUpEntity> testStartups2() throws Exception {
		List<StartUpEntity> str = service.selectMemberService(); // 테스트 서비스 사용
		return str;
	}
}
