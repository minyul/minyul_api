package com.minyul.api.controller;

import com.minyul.redis.TestRedis;
import com.minyul.session.TestSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/root")
@RestController
@RequiredArgsConstructor
public class TestController {

	@GetMapping("/test")
	public String testMethod() {
		return TestRedis.testRedisMessage() + TestSession.testSessionMessage();
	}
}
