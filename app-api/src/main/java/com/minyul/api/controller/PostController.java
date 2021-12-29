package com.minyul.api.controller;

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

	@GetMapping("/posts/{post_id}")
	public ResponseEntity<String> retrievePost(@PathVariable(value = "post_id") Long postId) {

		return ResponseEntity.ok().body(null);
	}
}
