package com.hist.innohi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class InnohiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnohiApiApplication.class, args);
	}

}
