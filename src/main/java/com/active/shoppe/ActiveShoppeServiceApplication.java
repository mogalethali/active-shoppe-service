package com.active.shoppe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ActiveShoppeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveShoppeServiceApplication.class, args);
	}

}
