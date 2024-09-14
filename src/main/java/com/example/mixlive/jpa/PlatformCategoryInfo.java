package com.example.mixlive.jpa;

import cn.hutool.json.JSONUtil;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.CategoryInfo;
import com.example.mixlive.model.category.bilibili.BiliCategoryInfo;
import com.example.mixlive.model.category.douyu.DouyuCategoryInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformCategoryInfo {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "platform_type")
    private PlatformType platformType;
    @Column(name = "json", columnDefinition = "longtext")
    private String json;

    public List<CategoryInfo> toCategoryInfos() {
        switch (platformType) {
            case bilibili:
                return new ArrayList<>(JSONUtil.toList(json, BiliCategoryInfo.class));
            case douyu:
                return new ArrayList<>(JSONUtil.toList(json, DouyuCategoryInfo.class));
            default:
                throw new IllegalArgumentException("PlatformType not found: " + platformType);
        }
    }

}
