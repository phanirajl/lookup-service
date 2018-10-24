package com.suhas.service.lookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LookupServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LookupServiceApplication.class, args);
	}
}


