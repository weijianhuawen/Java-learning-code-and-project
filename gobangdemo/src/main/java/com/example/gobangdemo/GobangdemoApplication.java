package com.example.gobangdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class GobangdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GobangdemoApplication.class, args);
	}

}
