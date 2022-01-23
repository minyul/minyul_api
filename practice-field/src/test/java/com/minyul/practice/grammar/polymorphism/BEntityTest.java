package com.minyul.practice.grammar.polymorphism;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BEntityTest {

	@DisplayName("걍 다형성 시험")
	@Test
	void test() {
		AEntity aEntity = new BEntity("name");
		// aEntity.x 역쉬 안되네
	}


}