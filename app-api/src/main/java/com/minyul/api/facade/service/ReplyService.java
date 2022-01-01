package com.minyul.api.facade.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {

	@Scheduled(cron = "0 0/1 * * * ?")
	public void pushReply() {
		System.out.println("스케줄러 테스트");
	}
}
