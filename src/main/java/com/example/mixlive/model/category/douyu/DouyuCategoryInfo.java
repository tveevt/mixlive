package com.example.mixlive.model.category.douyu;

import com.example.mixlive.model.category.CategoryInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DouyuCategoryInfo extends CategoryInfo {
    private String name;
    List<DouyuSubCategoryInfo> subCategoryInfos;
}
