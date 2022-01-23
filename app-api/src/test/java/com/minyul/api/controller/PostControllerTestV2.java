package com.minyul.api.controller;

import com.minyul.api.dto.post.PostRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTestV2 {

	@LocalServerPort
	int port;

	@BeforeEach
	public void setUp() {
		RestAssured.port = port;
	}

	// 국내 피드를 갖고오는 테스트와 다르게 RestAssured 를 썼음.
	@DisplayName("피드 저장")
	@Test
	void createPost() {

		PostRequest postRequest = new PostRequest("hu", "content");

		ExtractableResponse<Response> response = RestAssured
						.given().body(postRequest).contentType(MediaType.APPLICATION_JSON_VALUE).log().all()
						.when().post("/domestic/posts")
						.then().log().all()
						.extract();

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}
}
