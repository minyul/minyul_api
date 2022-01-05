package com.minyul.api.controller;

import com.minyul.api.dto.post.PostDto;
import com.minyul.api.facade.DomesticFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/domestic")
@RequiredArgsConstructor
@RestController
public class PostController {

	private final DomesticFacade domesticFacade;


	/**
	 * HttpEntity<T> 를 상속받았다. 이유는 !? stauts 를 사용할 수 없다. HtppEntity는 !
	 * private final Object status
	 *
	 * @return ResponseEntity<T>
	 * @author : Minyul
	 */
	@GetMapping("/posts/{post_id}")
	public ResponseEntity<PostDto> retrievePost(@PathVariable(value = "post_id") final Long postId) {

		return ResponseEntity.ok(domesticFacade.fetchPostById(postId));
	}
}
