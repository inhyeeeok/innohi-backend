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
@Table(name = "innohiBoard")
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bno")
	private int bno;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="regUser", nullable = false)
	private String regUser;
	
	@Column(name="updtUser")
	private String updtUser;
	
	@Column(name="updtDate")
	private String updtDate;
	
	@Column(name="viewCnt")
	private String viewCnt;
	
}
