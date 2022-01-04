package com.hist.innohi.controller;

import com.hist.innohi.dto.ResponseDTO;
import com.hist.innohi.model.StartUpEntity;
import com.hist.innohi.service.StartupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;

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

@Api(tags={"StartUp 정보를 제공하는 Controller"})
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
	@ApiImplicitParams({
		@ApiImplicitParam(name="keyword", value="정렬순서", defaultValue="no", required=true)
		, @ApiImplicitParam(name="offset", value="시작값", defaultValue="0")
		, @ApiImplicitParam(name="limit", value="제한값", defaultValue="10")
	})
	@ApiOperation(value="이노하이 스타트업 찾기", notes="전체 스타트업 조회")
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
