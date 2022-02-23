package com.minyul.practice;

import com.minyul.practice.grammar.GitHubCommitResponse;
import com.minyul.practice.grammar.GitHubResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class PracticeApp {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(PracticeApp.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {

		return args -> {
			RestTemplate restTemplate = restTemplateBuilder.build();
			GitHubResponse[] response1 =
							restTemplate.getForObject("https://api.github.com/users/minyul/repos", GitHubResponse[].class);
			Arrays.stream(response1).forEach(System.out::println);

			GitHubCommitResponse[] response2 =
							restTemplate.getForObject("https://api.github.com/repos/minyul/IndexInMyHead/commits", GitHubCommitResponse[].class);
			Arrays.stream(response2).forEach(System.out::println);
		};
	}
}
