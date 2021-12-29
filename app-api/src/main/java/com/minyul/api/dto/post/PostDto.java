package com.minyul.api.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

/**
 *  :  minyul
 *  Response Naming : [Domain][Role]Dto
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
}
