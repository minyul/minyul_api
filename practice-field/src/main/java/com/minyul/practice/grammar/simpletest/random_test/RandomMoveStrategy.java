package com.minyul.practice.grammar.simpletest.random_test;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int FORWARD_NUM = 4;
	private static final int MAX_BOUND = 10;

	@Override
	public boolean isMovable() {
		return generateRandomNumber() >= FORWARD_NUM;
	}

	private int generateRandomNumber() {
		Random random = new Random();

		return random.nextInt(MAX_BOUND);
	}
}
