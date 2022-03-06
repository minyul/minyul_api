package com.minyul.practice.grammar.simpletest;

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
