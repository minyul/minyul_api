package com.minyul.api.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minyul.rds.entity.Post;
import lombok.*;

import java.util.List;

/**
 *  Response Naming : [Domain][Role]Dto
 		@author : Minyul
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private Long id;
	private String title;
	private String content;
	private News news;

	@Singular
	private List<Integer> scores;

	@JsonIgnore
	private final String type = "NORMAL";

	public static PostDto of(Post post) {
		return PostDto.builder()
						.id(post.getId())
						.title(post.getTitle())
						.news(News.of("제목","본문"))
						.build();
	}

	/**
	 * 항상 어노테이션은 All -> No -> Builder -> Get 으로 간다.
	 * 보통은 바뀔 가능성, 뗄 가능성을 보고 가능성이 높은 것을 맨 위로 둔다.
	 * 다만, 그럴 일이 거의 없다고 판단 되는 경우 글자수대로 쌓는다.
	 * @Builder 패턴을 썼을 경우, final 또는 @Builder.Default 지만 내 경우 둘 다 써준다.
	 * @author : Minyul
	 */
	@Getter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class News {

		private String title;
		private String content;

		@Builder.Default
		private final String temp = "temp";

		public static News of(String title, String content) {

			return News.builder()
							.title(title)
							.content(content)
							.build();
		}
	}
}
