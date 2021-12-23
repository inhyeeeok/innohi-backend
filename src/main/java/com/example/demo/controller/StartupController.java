package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.StartUpsEntity;
import com.example.demo.service.StartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/startup")
public class StartupController {

	@Autowired
	private StartupService service;
	
	private final int defaultOffset = 0; 
	private final int defaultLimit = 10; 
	
	
//	@GetMapping("/insert")
//	public ResponseEntity<?> testStartups(StartUpsEntity data) {
//		HashMap<String, Object> str = service.testStartupService(data); // 테스트 서비스 사용
//		List<HashMap<String,Object>> list = new ArrayList<>();
//		list.add(str);
//		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
//		return str;
//	} 
	
//	@GetMapping("/findStartup")
//	public ResponseDTO<StartUpsEntity> selectAllStartups() throws Exception {
//		HashMap<String, Object> paramData = null;
//		List<StartUpsEntity> str = service.selectStartupService(paramData); // 테스트 서비스 사용
//		ResponseDTO<StartUpsEntity> response = ResponseDTO.<StartUpsEntity>builder().data(str).build();
//		return response;
//	}
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @return
	 * 
	 */
	
	@RequestMapping("/findStartup")
	public ResponseEntity<?> selectStartup(@RequestParam HashMap<String, Object> paramData, @RequestParam Integer offset, Integer limit) throws Exception {
//		if(offset == null){
//			offset = defaultOffset;
//		}
//		
//		if(limit == null){
//			limit = defaultLimit;
//		}
		
		System.out.println("test :"+ offset);
		
		List<StartUpsEntity> res = service.selectStartupService(paramData, offset, limit);
		ResponseDTO<StartUpsEntity> response = ResponseDTO.<StartUpsEntity>builder().data(res).build();
		return ResponseEntity.ok().body(response);
	}
	
//	@PostMapping("/findAllStartup")
//	public ResponseDTO<StartUpsEntity> testStartups2() throws Exception {
//		List<StartUpsEntity> str = service.selectStartupService(); // 테스트 서비스 사용
//		ResponseDTO<StartUpsEntity> response = ResponseDTO.<StartUpsEntity>builder().data(str).build();
//		return response;
//	}
}
