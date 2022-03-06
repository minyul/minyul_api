package com.minyul.practice.grammar.simpletest;

import java.util.Random;

public class Car {

	private static final int FORWARD_NUM = 4;
	private static final int MAX_BOUND = 10;

	private int position = 0;

	public void move() {
		if (getRandomNo() >= FORWARD_NUM)
			this.position++;
	}

	public int position() {

		return this.position;
	}

	private int getRandomNo() {
		Random random = new Random();
		return random.nextInt(MAX_BOUND);
	}
}
