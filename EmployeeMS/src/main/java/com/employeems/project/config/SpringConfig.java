package com.employeems.project.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

	@LoadBalanced
	@Bean
	public RestTemplate template() {

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}
