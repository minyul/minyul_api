package com.minyul.practice.grammar.simpletest.http_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubService {

	@Autowired
	private GithubFetcher githubFetcher;

	public void findGitHubContent() {

		githubFetcher.findGithubResponse();
	}
}
