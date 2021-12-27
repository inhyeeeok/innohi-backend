
package com.hist.innohi.service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hist.innohi.model.BoardEntity;
import com.hist.innohi.persistence.BoardRepository;


@Slf4j
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;

	public List<BoardEntity> selectBoardService(Integer offset, Integer limit) {
		List<BoardEntity> entity = null;
		Pageable pageWithElements = PageRequest.of(offset, limit, Sort.by("bno"));
		
		Page<BoardEntity> pageEntity = boardRepo.findAll(pageWithElements);
		entity = pageEntity.getContent();

		return entity;
	}

}
