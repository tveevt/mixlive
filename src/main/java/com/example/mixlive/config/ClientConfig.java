package com.example.mixlive.config;

import com.example.mixlive.client.RestTemplateFactory;
import com.example.mixlive.client.bilibili.BiliClient;
import com.example.mixlive.client.douyu.DouyuClient;
import com.example.mixlive.sign.DouyuSignProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    private final RestTemplateFactory restTemplateFactory;

    public ClientConfig(RestTemplateFactory restTemplateFactory) {
        this.restTemplateFactory = restTemplateFactory;
    }

    @Bean
    public BiliClient biliClient() {
        return new BiliClient(restTemplateFactory.create());
    }

    @Bean
    public DouyuClient douyuClient() {
        return new DouyuClient(restTemplateFactory.create(), douyuSignProcessor());
    }

    @Bean
    public DouyuSignProcessor douyuSignProcessor() {
        return new DouyuSignProcessor();
    }
}
