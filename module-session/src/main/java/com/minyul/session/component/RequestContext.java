package com.minyul.session.component;

import java.util.Map;
import java.util.Optional;

public interface RequestContext {

	Optional<Integer> userId();

	String userDisplayName();

	Optional<String> sid();

	String requestUri();

	Map<String, String> parameters();

	String header(String headerName);
}
