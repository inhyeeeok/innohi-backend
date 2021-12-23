package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StartUpsEntity;

import java.util.List;

@Repository
public interface StartUpsRepository extends JpaRepository<StartUpsEntity, String>{
	
	List<StartUpsEntity> findBysName(String sName);

	List<StartUpsEntity> findBysNo(int sNo);
}
