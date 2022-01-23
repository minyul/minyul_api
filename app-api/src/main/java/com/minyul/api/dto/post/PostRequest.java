package com.minyul.api.dto.post;

import com.minyul.rds.entity.Post;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * Request Dto 의 Naming : [ ]Request
 * Param Dto  -  : [ ]Param or [ ]Cond
 * @author : Minyul
 */
@Getter
public class PostRequest {

	@Length(max = 3)
	private String title;
	private String content;

	public PostRequest() {
		//
	}

	public PostRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}

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
