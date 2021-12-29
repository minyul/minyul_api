package com.minyul.api.facade.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minyul.api.dto.post.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

	private final ObjectMapper objectMapper;

	public void retrievePost(final Long postId) {
		try {
			PostDto postDto = objectMapper.readValue(new ClassPathResource("mockdata/post.json").getFile(), PostDto.class);

		} catch (IOException exception) {
			log.error("POST Service Exception : {}",exception.getMessage());
		}
	}
}
