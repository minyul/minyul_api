package com.minyul.practice.grammar.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class RandomGeneratorTest {

	private Generator generator;

	@BeforeEach
	void init() {
		// generator = () -> 3; Todo : Generator를 부르는 곳에서의 Test할 때는 Interface 구현체로.
		generator = new RandomGenerator();
	}

	@DisplayName("랜덤 점수 생성기 테스트")
	@Test
	void test_1_range_10() {
		Integer result = generator.makeNumber();
		assertThat(result, is(both(greaterThanOrEqualTo(1)).and(lessThanOrEqualTo(10))));
	}
}