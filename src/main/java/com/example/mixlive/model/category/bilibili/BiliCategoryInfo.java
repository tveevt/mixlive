package com.example.mixlive.model.category.bilibili;

import com.example.mixlive.model.category.CategoryInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BiliCategoryInfo extends CategoryInfo {
    private Integer id;
    private String name;
    List<BiliSubCategoryInfo> subCategoryInfos;

}
