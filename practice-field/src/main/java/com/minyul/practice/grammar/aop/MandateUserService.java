package com.minyul.practice.grammar.aop;

public class MandateUserService implements UserInterface {

	private RealUserServiceImpl realUserService;

	public MandateUserService() {
		this.realUserService = new RealUserServiceImpl();
	}

	@Override
	public String test1() {
		return realUserService.test1();
	}

	@Override
	public String test2() {
		return realUserService.test2();
	}
}
