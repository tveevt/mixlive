package com.example.mixlive.config;

import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.CategoryAction;
import com.example.mixlive.model.category.bilibili.BiliCategory;
import com.example.mixlive.model.category.douyu.DouyuCategory;
import com.example.mixlive.platform.bilibili.service.BiliLiveService;
import com.example.mixlive.platform.douyu.service.DouyuLiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class PlatformCategoryInitializer implements ApplicationRunner {

    @Value("${live.category.action:NONE}")
    private CategoryAction action;

    @Value("${live.category.platforms:ALL}")
    private String platformsConfig;

    private final BiliLiveService biliLiveService;
    private final DouyuLiveService douyuLiveService;

    @Override
    public void run(ApplicationArguments args) {
        log.info("初始化分区信息开始, action={}, platforms={}", action, platformsConfig);

        if (action == CategoryAction.NONE) {
            log.info("初始化分区信息完成");
            return;
        }

        List<PlatformType> targetPlatforms = parsePlatformTypes(platformsConfig);

        targetPlatforms.forEach(this::processPlatform);

        log.info("初始化分区信息完成");
    }

    private void processPlatform(PlatformType platformType) {
        switch (platformType) {
            case BILIBILI:
                if (action == CategoryAction.SKIP_EXISTS && biliLiveService.existsCategories()) {
                    log.info("B站分区数据已存在,跳过生成");
                    return;
                }
                List<BiliCategory> biliCategories = biliLiveService.generateCategories();
                biliLiveService.saveCategoriesToDB(biliCategories);
                break;

            case DOUYU:
                if (action == CategoryAction.SKIP_EXISTS && douyuLiveService.existsCategories()) {
                    log.info("斗鱼分区数据已存在,跳过生成");
                    return;
                }
                List<DouyuCategory> douyuCategories = douyuLiveService.generateCategories();
                douyuLiveService.saveCategoriesToDB(douyuCategories);
                break;

            default:
                log.warn("不支持的平台类型: {}", platformType);
        }
    }


    private List<PlatformType> parsePlatformTypes(String platformsConfig) {
        if ("ALL".equalsIgnoreCase(platformsConfig)) {
            return Arrays.asList(PlatformType.values());
        }
        return StreamEx.of(platformsConfig.split(","))
                       .map(String::trim)
                       .map(PlatformType::valueOf)
                       .toList();
    }
}
