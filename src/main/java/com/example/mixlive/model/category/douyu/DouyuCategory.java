package com.example.mixlive.model.category.douyu;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DouyuCategory {
    private String name;
    List<DouyuSubCategory> subCategories;
}
