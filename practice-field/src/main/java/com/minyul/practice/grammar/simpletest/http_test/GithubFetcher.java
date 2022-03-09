package com.minyul.practice.grammar.simpletest.http_test;

import com.minyul.practice.grammar.GitHubResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubFetcher {

	private final RestTemplate restTemplate;

	public GithubFetcher(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public GitHubResponse[] findGithubResponse() {

		return restTemplate.getForObject("https://api.github.com/users/minyul/repos", GitHubResponse[].class);
	}
}
