package com.minyul.practice.grammar.generator;

import java.util.Random;

public class RandomGenerator implements Generator {

	private Random random;

	public RandomGenerator() {
		this.random = new Random();
	}

	@Override
	public Integer makeNumber() {
		return random.nextInt(10) + 1;
	}
}
