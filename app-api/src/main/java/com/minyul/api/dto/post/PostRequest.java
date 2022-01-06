package com.minyul.api.dto.post;

import com.minyul.rds.entity.Post;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

/**
 * Request Dto 의 Naming : [ ]Request
 * Param Dto  -  : [ ]Param or [ ]Cond
 * @author : Minyul
 */
@Getter
public class PostRequest {

	private String title;
	private String content;

	public Post toEntity() {

		return Post.builder()
						.title(title)
						.build();
	}

	@Override
	public String toString() {

		return "PostRequest{" +
						"title='" + title + '\'' +
						", content='" + content + '\'' +
						'}';
	}
}
