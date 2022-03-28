package com.minyul.practice.grammar.simpletest.http_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 외부 API 같은 경우에는 제어권이 우리에게 없기에 Mock 을 써야만 한다.
 * API 통신에 요금이 발생한다면 매번 과금이 될 수 있다.
 * 통신이 불가능한 상황(ex.인터넷 연결 X)이라면 테스트를 할 수 없다.
 * 스프링이 올라간다음 테스트를 진행하기 때문에 속도가 느리다.
 */

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GithubFetcherTest {

	@Autowired
	private GithubService githubService;

	@DisplayName("test")
	@Test
	void test() {
		githubService.findGitHubContent();
	}
}