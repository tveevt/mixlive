package com.example.mixlive.config;

import com.example.mixlive.client.bilibili.BiliClient;
import com.example.mixlive.client.douyu.DouyuClient;
import com.example.mixlive.platform.douyu.service.sign.DouyuSignProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PlatformClientConfig {

    private final RestTemplateFactory restTemplateFactory;


    @Bean
    public BiliClient biliClient() {
        return new BiliClient(restTemplateFactory.createDefault());
    }

    @Bean
    public DouyuClient douyuClient() {
        return new DouyuClient(restTemplateFactory.createDefault(), new DouyuSignProcessor());
    }

}
