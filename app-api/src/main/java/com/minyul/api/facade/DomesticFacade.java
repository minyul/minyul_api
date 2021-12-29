package com.minyul.api.facade;

import com.minyul.api.facade.service.PostService;
import com.minyul.api.facade.service.ReplyService;
import com.minyul.api.facade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DomesticFacade {

	private final PostService postService;
	private final ReplyService replyService;
	private final UserService userService;

	public void fetchPostById(final Long postId) {
		postService.retrievePost(postId);
	}
}
