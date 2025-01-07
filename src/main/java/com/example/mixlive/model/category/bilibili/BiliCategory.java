package com.example.mixlive.model.category.bilibili;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BiliCategory {
    private Integer id;
    private String name;
    List<BiliSubCategory> subCategories;

}
