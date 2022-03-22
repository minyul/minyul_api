package com.minyul.practice.grammar.jungbog;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JungBogService {

	public Map<KeyDto, List<ValueDto>> jungBogMethod(List<BundleDto> bundleDtos) {
		Map<KeyDto, List<ValueDto>> map = new HashMap<>();
		for (BundleDto bundleDto : bundleDtos) {
			insertIntoJungBogMap(map, bundleDto.getKey(), bundleDto.getValue());
		}

		return map;
	}

	private void insertIntoJungBogMap(Map<KeyDto, List<ValueDto>> jungBogMap, KeyDto keyDto, ValueDto valueDto) {
		if (jungBogMap.containsKey(keyDto)) {
			jungBogMap.get(keyDto).add(valueDto);

			return ;
		}
		jungBogMap.put(keyDto, Stream.of(valueDto).collect(Collectors.toList()));
	}
}
