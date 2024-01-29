package com.cola.partnermatching;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cola.partnermatching.mapper")
public class PartnerMatchingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerMatchingApplication.class, args);
	}

}
