package com.minyul.api.facade.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minyul.api.dto.post.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

	private final ObjectMapper objectMapper;

	public PostDto retrievePost(final Long postId) {
		try {
			PostDto postDto = objectMapper.readValue(new ClassPathResource("mockdata/post.json").getFile(), PostDto.class);

			// Todo : 임시
			return postDto;

		} catch (Exception exception) {
			log.error("POST Service Exception : {}",exception.getMessage());
			throw new RuntimeException(exception.getMessage());
		}
	}
}

