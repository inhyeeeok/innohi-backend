package com.hist.innohi.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hist.innohi.model.BoardEntity;
import com.hist.innohi.model.StartUpEntity;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String>{
	

}
