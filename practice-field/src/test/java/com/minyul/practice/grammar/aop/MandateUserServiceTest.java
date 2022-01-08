package com.minyul.practice.grammar.aop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MandateUserServiceTest {

	private MandateUserService mandateUserService;

	@BeforeEach
	void init() {
		mandateUserService = new MandateUserService();
	}

	@DisplayName("위임 테스트")
	@Test
	void test_mandate() {
		System.out.println(mandateUserService.test1());
	}
}