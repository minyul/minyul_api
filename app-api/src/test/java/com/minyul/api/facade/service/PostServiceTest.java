package com.minyul.api.facade.service;

import com.minyul.api.dto.post.PostDto;
import com.minyul.api.exception.PostNotFoundException;
import com.minyul.rds.entity.Post;
import com.minyul.rds.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

	@InjectMocks
	PostService postService;

	@Mock
	PostRepository postRepository;

	@DisplayName("특정 국내 피드를 갖고 오는 테스트")
	@Test
	void test_retrieve_post() {

		// 전제
		final Post post = new Post(1L, "title");
		given(postRepository.findById(1L)).willReturn(Optional.of(post));

		PostDto resultPost = postService.retrievePost(1L);

		// 동일한지
		Assertions.assertEquals(resultPost.getId(), PostDto.of(post).getId());
		verify(postRepository).findById(anyLong());
	}

	@DisplayName("해당 Id에 맞는 피드가 존재하지 않을 때 예외를 던진다.")
	@Test
	void test_retrieve_post_exception() {
		// 해당 Id에 맞는 리소스가 비어있을 때.
		given(postRepository.findById(anyLong())).willReturn(Optional.empty());

		Assertions.assertThrows(PostNotFoundException.class, () -> postService.retrievePost(anyLong()));
		verify(postRepository).findById(anyLong());
	}
}