package com.minyul.api.facade.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minyul.api.dto.post.PostDto;
import com.minyul.api.exception.PostNotFoundException;
import com.minyul.rds.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.minyul.rds.repository.PostRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

	private final ObjectMapper objectMapper;
	private final PostRepository postRepository;

	/**
	 * JPA 에서 제공하는 EntityNotFoundException도 있음. orElseThrow(EntityNotFoundException::new) 가능
	 */
	public PostDto retrievePost(final Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Not Found Post"));
		return PostDto.of(post);
	}

	/**
	 * .json 으로 갖고 오는 [ frontend 에 mockData 보낼 때 ]
	 * @return : Post Mock Data
	 * @autor : Minyul
	 */
	public PostDto retrievePostByMockData() {
		try {

			return objectMapper.readValue(new ClassPathResource("mockdata/post.json").getFile(), PostDto.class);
		} catch (Exception exception) {

			log.error("POST Service Exception : {}",exception.getMessage());
			throw new RuntimeException(exception.getMessage());
		}
	}
}

