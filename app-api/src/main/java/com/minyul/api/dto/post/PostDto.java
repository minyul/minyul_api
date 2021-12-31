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

	@Singular
	private List<Integer> scores;

	@JsonIgnore
	private final String type = "NORMAL";

	public static PostDto of(Post post) {
		return PostDto.builder()
						.id(post.getId())
						.title(post.getTitle())
						.build();
	}
}
