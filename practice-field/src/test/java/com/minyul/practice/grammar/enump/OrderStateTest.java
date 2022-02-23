package com.minyul.practice.grammar.enump;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderStateTest {

	@DisplayName("책보고 ENUM 한번 해봄")
	@Test
	void test_enum() {
		OrderState preparing = OrderState.PREPARING;
	}
}