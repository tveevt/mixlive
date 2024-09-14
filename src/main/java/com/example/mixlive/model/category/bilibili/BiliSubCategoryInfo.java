package com.example.mixlive.model.category.bilibili;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BiliSubCategoryInfo {
    private String name;
    // private String parentAreaId;
    private String areaId;
    private List<SortTagInfo> sortTags;

}
