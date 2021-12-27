package com.hist.innohi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hist.innohi.model.TodoEntity;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String>{
//	List<TodoEntity> findByUserid(String userId);
	List<TodoEntity> findByUserId(String userId);
}
