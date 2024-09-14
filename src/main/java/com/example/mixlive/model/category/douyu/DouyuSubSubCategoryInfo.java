package com.example.mixlive.model.category.douyu;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DouyuSubSubCategoryInfo {
    private String name;
    private String categoryLevelAndId;

}
