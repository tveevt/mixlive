package com.example.mixlive.client;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class RestTemplateFactory {

    private final RestTemplateBuilder restTemplateBuilder;


    public RestTemplate create() {
        return create(5000, 5000);
    }

    public RestTemplate create(int connectTimeout, int readTimeout) {
        return restTemplateBuilder
                .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                .setConnectTimeout(Duration.ofMillis(connectTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }
}
