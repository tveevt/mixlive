package com.example.mixlive.model.category.bilibili;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BiliSubCategory {
    private String name;
    private String areaId;
    private List<SortTagInfo> sortTags;

}
