//package com.minyul.practice.grammar.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//// * 기존 restTemplate
//@Component
//public class RestTemplateConfig {
//
//    @Bean
//    public RestTemplate restTemplate(
//            int connectionTimeout,
//            int readTimeout) {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(this.httpRequestFactory(connectionTimeout, readTimeout));
//
//        return restTemplate;
//    }
//
//    private HttpComponentsClientHttpRequestFactory httpRequestFactory(int connectTimeout, int readTimeout) {
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setReadTimeout(readTimeout);
//        httpRequestFactory.setConnectTimeout(connectTimeout);
//
//        return httpRequestFactory;
//    }
//}
