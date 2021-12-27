package com.hist.innohi.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hist.innohi.model.StartUpEntity;

import java.util.List;

@Repository
public interface StartUpRepository extends JpaRepository<StartUpEntity, String>{
	
	List<StartUpEntity> findByname(String name);
	
	List<StartUpEntity> findByno(int no);
	
	List<StartUpEntity> findAllBycategory(String category, Pageable firstPageWithTwoElements);
	
	List<StartUpEntity> findAllBytechType(String techType, Pageable firstPageWithTwoElements);

}
