package com.example.mixlive.platform.douyu.service;

import cn.hutool.json.JSONUtil;
import com.example.mixlive.jpa.PlatformCategory;
import com.example.mixlive.jpa.PlatformCategoryRepository;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.douyu.DouyuCategory;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DouyuCategoryCacheService {
    private final Cache<PlatformType, List<DouyuCategory>> cache;

    private final PlatformCategoryRepository platformCategoryRepository;

    public DouyuCategoryCacheService(PlatformCategoryRepository platformCategoryRepository) {
        cache = Caffeine.newBuilder()
                        .expireAfterWrite(1, TimeUnit.DAYS)
                        .build();
        this.platformCategoryRepository = platformCategoryRepository;
    }

    public List<DouyuCategory> get() {
        return cache.get(PlatformType.DOUYU,
                key -> buildDouyuCategoriesFromDB());
    }

    private List<DouyuCategory> buildDouyuCategoriesFromDB() {
        PlatformCategory platformCategory =
                platformCategoryRepository.findByPlatformType(PlatformType.DOUYU)
                                          .orElseThrow(() ->
                                                  new IllegalArgumentException("PlatformType category not found"));
        return JSONUtil.toList(platformCategory.getJsonContent(), DouyuCategory.class);
    }

    public void put(List<DouyuCategory> douyuCategories) {
        cache.put(PlatformType.DOUYU, douyuCategories);
    }
}
