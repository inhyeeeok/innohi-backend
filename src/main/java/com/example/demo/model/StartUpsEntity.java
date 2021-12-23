package com.example.demo.model;

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
@Table(name = "STARTUP")
public class StartUpsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="S_NO")
	private int no;
	
	@Column(name="S_NAME", nullable = false)
	private String name;
	
	@Column(name="S_CATEGORY", nullable = false)
	private String category;
	
	@Column(name="S_TECH_TYPE")
	private String techType;
	
	@Column(name="S_MAIN_SERVICE")
	private String mainService;
	
	@Column(name="S_EMPLOYEE_NUM")
	private String employeeNum;
	
	@Column(name="S_LOCATION")
	private String location;
	
	@Column(name="S_SERVICE_DETL")
	private String serviceDetl;
	
	@Column(name="S_SPECIAL_FEATURE")
	private String specialFeature;
	
	@Column(name="S_RESEARCHED_TIME")
	private String researchedTime;
}
