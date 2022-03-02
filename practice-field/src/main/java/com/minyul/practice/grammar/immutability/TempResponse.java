package com.minyul.practice.grammar.immutability;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TempResponse {

	private final List<String> tempList;
	private final int[] tempArray;

	public TempResponse(final List<String> tempList, final int[] tempArray) {
		this.tempArray = Arrays.copyOf(tempArray, tempArray.length);
		this.tempList = new ArrayList<>(tempList);
	}

	public int[] getTempArray() {

		return !ObjectUtils.isEmpty(tempArray) ? tempArray.clone() : null;
	}

	public List<String> getTempList() {

		return Collections.unmodifiableList(tempList);
	}
}
