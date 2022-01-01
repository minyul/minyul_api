package com.minyul.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.minyul"})
@EnableFeignClients(basePackages = {"com.minyul.session"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
