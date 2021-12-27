package com.hist.innohi.controller;

import com.hist.innohi.dto.ResponseDTO;
import com.hist.innohi.model.BoardEntity;
import com.hist.innohi.service.BoardService;
import com.hist.innohi.service.StartupService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	/**
	 * @author ihhyeok
	 * @param {"paramData":{}, "offset":0, "limit":10}
	 * @param {@literal null}
	 * @return
	 * {@link StartupService}
	 * 
	 */
	
	@ApiOperation(value="이노하이 게시판 정보 생성", notes="test")
	@GetMapping(value="/selectBoard", produces="application/json; charset=UTF-8")
	public HttpEntity<?> selectBoard(@RequestParam(defaultValue="0") Integer offset, @RequestParam(defaultValue="10") Integer limit)  throws Exception {
		List<BoardEntity> res = service.selectBoardService(offset, limit);
		ResponseDTO<BoardEntity> response = ResponseDTO.<BoardEntity>builder().data(res).successYn(true).build();
		return ResponseEntity.ok().body(response);
	}
}
