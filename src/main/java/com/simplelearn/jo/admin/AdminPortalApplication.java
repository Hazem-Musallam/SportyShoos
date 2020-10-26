package com.simplelearn.jo.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAsync
@EnableCaching
@EnableJpaAuditing
@EnableScheduling
@ComponentScan
public class AdminPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminPortalApplication.class, args);
	}
}