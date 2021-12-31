package com.minyul.rds.repository;

import com.minyul.rds.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PostRepositoryTest {

	@Mock
	PostRepository postRepository;

	@DisplayName("피드를 저장하고 저장한 피드를 잘 갖고오는 지 확인")
	@Test
	void test_save_post() {

		// 전제
		final Post post = new Post(1L, "title");
		given(postRepository.save(post)).willReturn(post);

		Post resultPost = postRepository.save(post);

		verify(postRepository, times(1)).save(post);
		Assertions.assertEquals(post.getId(), resultPost.getId(), 2L);
	}
}