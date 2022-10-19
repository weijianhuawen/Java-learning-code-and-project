package com.example.musicdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//因为在SpringBoot中，默认的Spring Security生效了的，此时的接口都是被保护的，我们需要通过验证才能正常的访问。此时通过上述配置，即可禁用默认的登录验证。
@SpringBootApplication(exclude =
		{org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class MusicdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicdemoApplication.class, args);
	}

}
