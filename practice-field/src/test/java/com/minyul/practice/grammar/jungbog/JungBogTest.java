package com.minyul.practice.grammar.jungbog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		BundleDto bundleDto = new BundleDto(new KeyDto("key_1"), new ValueDto("a"));
		BundleDto bundleDto1 = new BundleDto(new KeyDto("key_1"), new ValueDto("b"));
		BundleDto bundleDto2 = new BundleDto(new KeyDto("key_2"), new ValueDto("a"));
		List<BundleDto> bundleDtos = new ArrayList<>(List.of(bundleDto1, bundleDto2, bundleDto));
		Map<KeyDto, List<ValueDto>> result = jungBogService.jungBogMethod(bundleDtos);

		assertThat(result.size()).isEqualTo(2);
	}
}
