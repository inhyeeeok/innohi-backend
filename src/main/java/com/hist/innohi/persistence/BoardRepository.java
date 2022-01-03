package com.hist.innohi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hist.innohi.model.BoardEntity;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String>{
	

}
