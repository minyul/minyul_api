package com.minyul.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.Retryer;

@Configuration
public class ApiClientConfig {

	@Bean
	public Retryer retryer() {
		return Retryer.NEVER_RETRY;
	}

	@Bean
	public RequestInterceptor userApiRequestInterceptor() {
		return requestTemplate -> requestTemplate
						.header("Accept", "application/json");
	}
}