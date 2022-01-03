package com.hist.innohi.controller;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class StartupControllerTest {
	@Autowired
	MockMvc mvc;
	
	@Autowired
	StartupController stc;
	
	@Autowired
	private WebApplicationContext ctx;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(stc).build();
		this.mvc = MockMvcBuilders
				.webAppContextSetup(ctx)
				.addFilter(new CharacterEncodingFilter("UTF-8", true))
				.alwaysExpect(MockMvcResultMatchers.status().isOk())
				.alwaysExpect(MockMvcResultMatchers.jsonPath("$.successYn").value(true))
				.alwaysDo(MockMvcResultHandlers.print())
				.build();
	}
	
	@Before
	public void setUpParam() {
//		StartUpEntity findAllStartupTest = new StartUpEntity();
		HashMap<String, Object> findAllStartupTest = new HashMap<>();
		findAllStartupTest.put("keyword", "no");
		findAllStartupTest.put("offset", "0");
		findAllStartupTest.put("limit", "10");
		
	}
	
	@Test
	public void test() throws Exception {
		log.info("test!!!");
		
		mvc.perform(
				MockMvcRequestBuilders
				.get("/api/v1/startup/findAllStartup")
				.accept(MediaType.APPLICATION_JSON)
				.param("keyword", "no")
				.param("offset", "20")
				.param("limit", "5")
				)
//		.andExpect(MockMvcResultMatchers.content().json(""))
//		.andExpect(MockMvcResultMatchers.jsonPath("$.successYn").value(false))
//		.andReturn().getResponse().getContentAsString()
		;
		
		mvc.perform(
				MockMvcRequestBuilders
				.get("/api/v1/startup/findStartup")
				.accept(MediaType.APPLICATION_JSON)
				.param("key", "category")
				.param("value", "의료")
				.param("offset", "0")
				.param("limit", "1")
				)
		;
	}
	
	
}
