package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
//@SequenceGenerator(
//		name = "SNO_SEQ_GENERATOR",
//        sequenceName = "USER_SEQ", // 시퀸스 명
//        initialValue = 1, // 초기 값
//        allocationSize = 1 // 미리 할당 받을 시퀸스 수
//)
@Table(name = "startup")
public class StartUpsEntity {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_no;
	private String sName;
	private String sCategory;
	private String sTechType;
}
