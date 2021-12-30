package com.minyul.api.external;

import com.minyul.api.exception.ExternalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Component
public class ExternalApi {

	private final static String COMMON_PARAM = "min_yul";

	private final RestTemplate restTemplate;

	@Value("${external.api}")
	private final String externalUrl;

	public ExternalDto externalData(String searchWord, Pageable pageable) {
		URI uri = commonParamsBuilder(externalUrl(), pageable)
						.queryParam("searchWord", searchWord)
						.build(false)
						.toUri();

		return fetch(uri);
	}

	private ExternalDto fetch(URI uri) {
		HttpHeaders headers = new HttpHeaders();
		try {
			ResponseEntity<ExternalDto> response =
							restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), ExternalDto.class);

			return response.getBody();
		} catch (RestClientException e) {
			String errorMessage = String.format("External API ERROR :  %s", uri);
			log.error(errorMessage);
			throw new ExternalException(errorMessage);
		}
	}


	private UriComponentsBuilder externalUrl() {
		URI url = URI.create(externalUrl);
		return UriComponentsBuilder.fromHttpUrl(String.valueOf(url));
	}

	/**
	 * 공통으로 쓰는 URL Param
	 */
	private UriComponentsBuilder commonParamsBuilder(UriComponentsBuilder builder, Pageable pageable) {
		return builder.queryParam("common", COMMON_PARAM)
						.queryParam("start", pageable.getOffset())
						.queryParam("size", pageable.getPageSize());
	}
}
