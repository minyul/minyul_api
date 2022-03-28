package com.minyul.practice.grammar.simpletest.random_test;

import com.minyul.practice.grammar.simpletest.random_test.MoveStrategy;

public class TestStrategy implements MoveStrategy {

	private int number;

	public TestStrategy(final int number) {
		this.number = number;
	}

	@Override
	public boolean isMovable() {

		return number >= 4;
	}
}
