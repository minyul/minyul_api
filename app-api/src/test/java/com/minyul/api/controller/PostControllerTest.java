package com.minyul.api.controller;

import com.minyul.api.dto.post.PostDto;
import com.minyul.api.facade.DomesticFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * PostController Test
 * @author : Minyul
 */
@WebMvcTest(PostController.class)
class PostControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	DomesticFacade facade;

	@DisplayName("특정 국내 피드를 갖고 오는 테스트")
	@Test
	void test_retrieve_post() throws Exception {

		PostDto post = PostDto.builder()
						.content("content")
						.id(1L)
						.build();

		// 가정
		given(facade.fetchPostById(1L)).willReturn(post);

		// 예측
		mockMvc.perform(get("/domestic/posts/{post_id}", 1L)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(content().contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id").value(1L));
	}
}
