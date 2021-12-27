package com.hist.innohi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userNo")
	private int userNo;
	
	@Column(name="loginId", nullable = false)
	private String loginId;
	
	@Column(name="userPwd", nullable = false)
	private String userPwd;
	
	@Column(name="userName", nullable = false)
	private String userName;
	
	@Column(name="regDate", nullable = false)
	private String regDate;
	
//	@Column(name="blockYn", nullable = false)
//	private String blockYn;
//	
//	@Column(name="adminYn", nullable = false)
//	private String adminYn;
	
}
