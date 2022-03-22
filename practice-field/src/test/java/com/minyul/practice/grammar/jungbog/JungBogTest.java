package com.minyul.practice.grammar.jungbog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("중복 테스트")
public class JungBogTest {

	private JungBogService jungBogService;

	@BeforeEach
	void init() {
		jungBogService = new JungBogService();
	}

	@DisplayName("객체 중복 테스트")
	@Test
	void JungBogObjectTest() {
		KeyDto keyDto1 = new KeyDto("key_1");
		KeyDto keyDto2 = new KeyDto("key_1");

		assertThat(keyDto1).isEqualTo(keyDto2);
	}

	@DisplayName("객체 중복 Map 테스트")
	@Test
	void JungBogServiceTest() {
		System.out.println(jungBogService);
	}
}
