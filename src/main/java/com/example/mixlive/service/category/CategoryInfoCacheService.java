package com.example.mixlive.service.category;

import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.CategoryInfo;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import one.util.streamex.EntryStream;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class CategoryInfoCacheService {

    private Cache<PlatformType, List<CategoryInfo>> cache;

    private final CategoryInfoService categoryInfoService;

    public CategoryInfoCacheService(CategoryInfoService categoryInfoService) {
        this.categoryInfoService = categoryInfoService;
        cache = Caffeine.newBuilder()
                        .expireAfterWrite(1, TimeUnit.DAYS)
                        .build();
    }

    public List<CategoryInfo> get(PlatformType platformType) {
        return cache.get(platformType, categoryInfoService::generateAndSave);
    }

    public Map<PlatformType, List<CategoryInfo>> getAll() {
        return cache.getAll(Arrays.asList(PlatformType.values()),
                key -> categoryInfoService.generateAndSaveAll());
    }

    public void cache(PlatformType platformType, List<CategoryInfo> categoryInfos) {
        cache.put(platformType, categoryInfos);
    }

    public void cache(Map<PlatformType, List<CategoryInfo>> platformTypeToCategoryInfos) {
        EntryStream.of(platformTypeToCategoryInfos)
                   .forKeyValue(cache::put);
    }
}
