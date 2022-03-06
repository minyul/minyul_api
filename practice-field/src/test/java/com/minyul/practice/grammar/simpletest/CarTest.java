package com.minyul.practice.grammar.simpletest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Random같은 어려운 테스트 연습")
class CarTest {

	Car car;

	@BeforeEach
	void init() {
		Car car = new Car();
	}

	@DisplayName("4이상일 때, 움직인다.")
	@Test
	void move() {
		//
		car.move();
	}
}