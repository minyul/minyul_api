package com.minyul.api.facade.service;

import org.awaitility.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.*;

/**
 * Todo : 안되는 이유 나도 몰라
 * 2022-01-01 나중에 해볼것
 */

//@SpringBootApplication
//public class SchedulerTest {
//
//	@Mock
//	private ReplyService replyService;
//
//	@DisplayName("답변을 자동으로 푸시하는 스케줄러 테스트")
//	@Test
//	void test_push_reply_by_scheduler() {
//		await().atMost(Duration.ONE_MINUTE)
//						.untilAsserted(() -> verify(replyService, atLeast(1)).pushReply());
//	}
//}
