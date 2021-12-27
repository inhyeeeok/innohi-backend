package com.hist.innohi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hist.innohi.model.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	List<UserEntity> findByloginId(String loginId);

}
