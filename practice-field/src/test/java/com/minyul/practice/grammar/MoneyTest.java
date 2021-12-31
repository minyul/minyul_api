package com.minyul.practice.grammar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

	@DisplayName("돈 잘 추가되는 지 확인하는 테스트")
	@Test
	void test_plus_money() throws NoSuchFieldException, IllegalAccessException {
		Money money = Money.ZERO;
		money.plus(1_000L);

		Field amount = money.getClass().getDeclaredField("amount");
		amount.setAccessible(true);
		Long amountResult = (Long)amount.get(money);
		assertThat(amountResult).isEqualTo(1_000);
	}
}