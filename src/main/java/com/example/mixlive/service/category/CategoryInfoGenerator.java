package com.example.mixlive.service.category;

import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.CategoryInfo;

import java.util.List;

public interface CategoryInfoGenerator {
    PlatformType getPlatformType();

    default boolean isSupport(PlatformType platformType) {
        return getPlatformType().equals(platformType);
    }

    List<CategoryInfo> generate();
}
