package com.example.mixlive.service.category;

import cn.hutool.json.JSONUtil;
import com.example.mixlive.jpa.PlatformCategoryInfo;
import com.example.mixlive.jpa.PlatformCategoryInfoRepository;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.CategoryInfo;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.EntryStream;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;

@Service
@Slf4j
public class CategoryInfoService {

    private Map<PlatformType, CategoryInfoGenerator> CategoryInfoGeneratorByPlatformType;

    private final PlatformCategoryInfoRepository platformCategoryInfoRepository;


    public CategoryInfoService(List<CategoryInfoGenerator> categoryInfoGenerators,
                               PlatformCategoryInfoRepository platformCategoryInfoRepository) {
        this.platformCategoryInfoRepository = platformCategoryInfoRepository;
        this.CategoryInfoGeneratorByPlatformType = StreamEx.of(categoryInfoGenerators)
                                                           .toMap(CategoryInfoGenerator::getPlatformType, identity());
    }

    public Map<PlatformType, List<CategoryInfo>> generateAndSaveAll() {
        return generateAndSave(Arrays.asList(PlatformType.values()));
    }

    public List<CategoryInfo> generateAndSave(PlatformType platformType) {
        return generateAndSave(Collections.singletonList(platformType)).get(platformType);
    }

    public Map<PlatformType, List<CategoryInfo>> generateAndSave(List<PlatformType> platformTypes) {
        Map<PlatformType, List<CategoryInfo>> platformTypeToCategoryInfos =
                StreamEx.of(platformTypes)
                        .toMap(platformType -> CategoryInfoGeneratorByPlatformType.get(platformType).generate());
        List<PlatformCategoryInfo> platformCategoryInfos =
                EntryStream.of(platformTypeToCategoryInfos)
                           .mapKeyValue(this::toPlatformCategory)
                           .toList();

        platformCategoryInfoRepository.saveAll(platformCategoryInfos);
        return platformTypeToCategoryInfos;
    }

    private PlatformCategoryInfo toPlatformCategory(PlatformType platformType, List<CategoryInfo> categoryInfos) {
        return PlatformCategoryInfo.builder()
                                   .platformType(platformType)
                                   .json(JSONUtil.toJsonStr(categoryInfos))
                                   .build();
    }

    public Map<PlatformType, List<CategoryInfo>> getAll() {
        return StreamEx.of(platformCategoryInfoRepository.findAll())
                       .toMap(PlatformCategoryInfo::getPlatformType, PlatformCategoryInfo::toCategoryInfos);
    }

    public List<CategoryInfo> get(PlatformType platformType) {
        PlatformCategoryInfo platformCategoryInfo =
                platformCategoryInfoRepository.findByPlatformType(platformType)
                                              .orElseThrow(() ->
                                                      new IllegalArgumentException("PlatformType not found: " + platformType));
        return platformCategoryInfo.toCategoryInfos();

    }

}
