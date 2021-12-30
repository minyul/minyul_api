package com.minyul.api.facade.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minyul.api.dto.post.PostDto;
import com.minyul.rds.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.minyul.rds.repository.PostRepository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

	private final ObjectMapper objectMapper;
	private final PostRepository postRepository;

	public PostDto retrievePost(final Long postId) {
		Optional<Post> post = postRepository.findById(postId);
		post.get();
		return null;
	}

	public PostDto retrievePostByMockData() {
		try {

			return objectMapper.readValue(new ClassPathResource("mockdata/post.json").getFile(), PostDto.class);
		} catch (Exception exception) {

			log.error("POST Service Exception : {}",exception.getMessage());
			throw new RuntimeException(exception.getMessage());
		}
	}
}

