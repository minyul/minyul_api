package com.minyul.practice.grammar.simpletest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Random같은 어려운 테스트 연습")
class CarTest {

	Car car;

	@BeforeEach
	void init() {
		car = new Car();
	}

	@DisplayName("전진한다.")
	@Test
	void move() {
		// when
		car.move(()-> true);

		// then
		assertThat(car.position()).isEqualTo(1);
	}

	@DisplayName("5 이상 일 때, 전진한다")
	@Test
	void number_4_move() {
		// given
		MoveStrategy moveStrategy = new TestStrategy(5);

		// when
		car.move(moveStrategy);

		// then
		assertThat(car.position()).isEqualTo(1);
	}
}