package com.example.mixlive.config;

import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.CategoryInfo;
import com.example.mixlive.service.category.CategoryInfoCacheService;
import com.example.mixlive.service.category.CategoryInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class CategoryInfoLoaderRunner implements ApplicationRunner {

    @Value("${live.categoryInfo.recreate:false}")
    private boolean shouldRecreateCategoryInfo;

    private final CategoryInfoService categoryInfoService;

    private final CategoryInfoCacheService categoryInfoCacheService;

    @Override
    public void run(ApplicationArguments args) {
        log.info("初始化分区信息开始");

        if (shouldRecreateCategoryInfo) {
            Map<PlatformType, List<CategoryInfo>> all = categoryInfoService.generateAndSaveAll();
            log.info("分区信息重新生成完成");
            categoryInfoCacheService.cache(all);
            log.info("分区信息缓存完成");
            return;
        } else {
            Map<PlatformType, List<CategoryInfo>> all = categoryInfoService.getAll();
            log.info("分区信息加载完成");
            categoryInfoCacheService.cache(all);
            log.info("分区信息缓存完成");
        }
        StreamEx.of(PlatformType.values())
                .forEach(platformType -> {
                    List<CategoryInfo> categoryInfos = categoryInfoCacheService.get(platformType);
                    log.info("平台 " + platformType + " 父分区信息大小 " + categoryInfos.size());
                });
        log.info("初始化分区信息完成");
    }

}
