package com.hist.innohi.controller;

import com.hist.innohi.dto.ResponseDTO;
import com.hist.innohi.model.StartUpEntity;
import com.hist.innohi.service.StartupService;

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
@RequestMapping("api/v1/startup")
public class StartupController {

	@Autowired
	private StartupService service;
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link StartupService}
	 * 
	 */
	
	@GetMapping(value="/findStartup", produces="application/json; charset=UTF-8")
	public HttpEntity<?> selectStartup(@RequestParam(required=true) String key, @RequestParam(required=true)String value, @RequestParam(defaultValue="0") Integer offset, @RequestParam(defaultValue="10") Integer limit)  throws Exception {
		List<StartUpEntity> res = service.selectStartupService(key, value, offset, limit);
		ResponseDTO<StartUpEntity> response = ResponseDTO.<StartUpEntity>builder().data(res).successYn(true).build();
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link StartupService}
	 * 
	 */
	
	@GetMapping(value="/findAllStartup", produces="application/json; charset=UTF-8")
	public HttpEntity<?> selectAllStartup(@RequestParam(defaultValue="no", required=true) String keyword, @RequestParam(defaultValue="0") Integer offset, @RequestParam(defaultValue="10") Integer limit) throws Exception {
		List<StartUpEntity> res = service.selectAllStartupService(keyword, offset, limit);
		ResponseDTO<StartUpEntity> response = ResponseDTO.<StartUpEntity>builder().data(res).successYn(true).build();
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link StartupService}
	 * 
	 */
	
	@PostMapping(value="/insertStartup", produces="application/json; charset=UTF-8")
	public HttpEntity<?> insertStartup(@RequestBody StartUpEntity param) throws Exception {
		ResponseDTO<StartUpEntity> response = null;
		
		if(param.getCategory() == null || param.getCategory().isEmpty() || 
				param.getName() == null || param.getName().isEmpty() || 
						param.getTechType() == null || param.getTechType().isEmpty()){
			response = ResponseDTO.<StartUpEntity>builder().data(null).successYn(false).error("A required value is missing").build();
		}else{
			List<StartUpEntity> res = service.insertStartupService(param);
			response = ResponseDTO.<StartUpEntity>builder().data(res).successYn(true).build();
		}
		return ResponseEntity.ok().body(response);
	}
}
