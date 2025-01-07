package com.example.mixlive.model.category.douyu;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DouyuSubCategory {
    private String name;
    private List<DouyuSubSubCategory> subSubCategories;

}
