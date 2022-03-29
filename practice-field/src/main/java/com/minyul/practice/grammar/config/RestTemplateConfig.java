package com.minyul.practice.grammar.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// * 기존 restTemplate
@Component
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(
            int connectionTimeout,
            int readTimeout) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(this.httpRequestFactory(connectionTimeout, readTimeout));

        return restTemplate;
    }

    private HttpComponentsClientHttpRequestFactory httpRequestFactory(int connectTimeout, int readTimeout) {
        HttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(120)
                .setMaxConnPerRoute(60)
                .setConnectionReuseStrategy(new NoConnectionReuseStrategy()) // Todo : nohttpresponseexception
                .build();

        // HttpClientBuilder, by default, sets pool size per route (host) to 5 and total pool size to 10

        HttpComponentsClientHttpRequestFactory httpRequestFactory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        httpRequestFactory.setReadTimeout(readTimeout);
        httpRequestFactory.setConnectTimeout(connectTimeout);

        return httpRequestFactory;
    }
}
