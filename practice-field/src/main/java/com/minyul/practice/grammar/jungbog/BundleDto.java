package com.minyul.practice.grammar.jungbog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BundleDto {
	private KeyDto key;
	private ValueDto value;
}
