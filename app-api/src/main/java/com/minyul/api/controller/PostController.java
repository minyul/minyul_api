package com.minyul.api.controller;

import com.minyul.api.dto.post.PostDto;
import com.minyul.api.dto.post.PostRequest;
import com.minyul.api.facade.DomesticFacade;
import com.minyul.rds.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

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

	// Response 그냥 임시로 박아놓은거임. 딱히 의미 없음. ㅋ_ㅋ
	@PostMapping("/posts")
	public ResponseEntity<DomesticFacade.CreateTempResponse> createPost(@RequestBody @Valid final PostRequest postRequest) {
		log.info("PostRequest value : {}", postRequest.toString());
		domesticFacade.createPost(postRequest);

		return ResponseEntity.created(URI.create("/posts/" + 1)).body(domesticFacade.createPost(postRequest));
	}
}
