package com.minyul.practice.grammar;

public class Money {

	public static final Money ZERO = Money.won(0L);

	private Long amount;

	public static Money won(Long amount) {
		return new Money(amount);
	}

	Money(Long amount) {
		this.amount = amount;
	}

	public Money plus(Long money) {
		amount += money;
		return this;
	}
}
