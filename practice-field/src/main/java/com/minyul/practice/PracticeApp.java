package com.minyul.practice;

import com.minyul.practice.grammar.GitHubCommitResponse;
import com.minyul.practice.grammar.GitHubResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@SpringBootApplication
public class PracticeApp {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@Autowired
	WebClient.Builder webClientBuilder;

	public static void main(String[] args) {
		SpringApplication.run(PracticeApp.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {

		return args -> {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			// Todo : Rest Template
//			RestTemplate restTemplate = restTemplateBuilder.build();
//			GitHubResponse[] response1 =
//							restTemplate.getForObject("https://api.github.com/users/minyul/repos", GitHubResponse[].class);
//			Arrays.stream(response1).forEach(System.out::println);
//
//			GitHubCommitResponse[] response2 =
//							restTemplate.getForObject("https://api.github.com/repos/minyul/IndexInMyHead/commits", GitHubCommitResponse[].class);
//			Arrays.stream(response2).forEach(System.out::println);

			// Todo : Web Client
			WebClient webClient = webClientBuilder.baseUrl("https://api.github.com").build();
			Mono<GitHubResponse[]> reposeMonoResult = webClient.get().uri("/users/minyul/repos")
							.retrieve()
							.bodyToMono(GitHubResponse[].class);

			Mono<GitHubCommitResponse[]> commitMonoResult = webClient.get().uri("/repos/minyul/IndexInMyHead/commits")
							.retrieve()
							.bodyToMono(GitHubCommitResponse[].class);

			reposeMonoResult.doOnSuccess(data -> {
				Arrays.stream(data).forEach(r -> {
					System.out.println(r.getId());
				});
			}).subscribe();

			commitMonoResult.doOnSuccess(data -> {
				Arrays.stream(data).forEach(r -> {
					System.out.println(r.getSha());
				});
			}).subscribe();

			stopWatch.stop();
			System.out.println(stopWatch.prettyPrint());
		};
	}
}
