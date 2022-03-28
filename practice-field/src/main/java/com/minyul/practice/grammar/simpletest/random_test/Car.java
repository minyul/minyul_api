package com.minyul.practice.grammar.simpletest.random_test;

public class Car {

	private int position = 0;

	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			this.position++;
		}
	}

	public int position() {

		return this.position;
	}
}
