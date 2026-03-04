package com.waqar.ship.shorturl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShorturlApplication {

	static void main(String[] args) {
		SpringApplication.run(ShorturlApplication.class, args);
	}

}
