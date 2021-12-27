package com.minyul.session.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
public class RequestContextImpl implements RequestContext {

	private final HttpServletRequest request;

	@Override
	public Optional<Integer> userId() {
		return Optional.empty();
	}

	@Override
	public String userDisplayName() {
		return "user_display_name";
	}

	@Override
	public Optional<String> sid() {
		return Optional.of("sid");
	}

	@Override
	public String requestUri() {
		return "request_uri";
	}

	@Override
	public Map<String, String> parameters() {
		return Collections.EMPTY_MAP;
	}

	@Override
	public String header(String headerName) {
		return "header";
	}
}
