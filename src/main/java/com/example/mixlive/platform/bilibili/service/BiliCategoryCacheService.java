package com.example.mixlive.platform.bilibili.service;

import cn.hutool.json.JSONUtil;
import com.example.mixlive.jpa.PlatformCategory;
import com.example.mixlive.jpa.PlatformCategoryRepository;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.bilibili.BiliCategory;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BiliCategoryCacheService {
    private final Cache<PlatformType, List<BiliCategory>> cache;

    private final PlatformCategoryRepository platformCategoryRepository;

    public BiliCategoryCacheService(PlatformCategoryRepository platformCategoryRepository) {
        cache = Caffeine.newBuilder()
                        .expireAfterWrite(1, TimeUnit.DAYS)
                        .build();
        this.platformCategoryRepository = platformCategoryRepository;
    }

    public List<BiliCategory> get() {
        return cache.get(PlatformType.BILIBILI,
                key -> buildBiliCategoriesFromDB());
    }

    private List<BiliCategory> buildBiliCategoriesFromDB() {
        PlatformCategory platformCategory =
                platformCategoryRepository.findByPlatformType(PlatformType.BILIBILI)
                                          .orElseThrow(() ->
                                                  new IllegalArgumentException("PlatformType category not found"));
        return JSONUtil.toList(platformCategory.getJsonContent(), BiliCategory.class);

    }

    public void put(List<BiliCategory> biliCategories) {
        cache.put(PlatformType.BILIBILI, biliCategories);
    }
}
