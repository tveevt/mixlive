package com.example.mixlive.platform.douyu.service;

import cn.hutool.json.JSONUtil;
import com.example.mixlive.client.douyu.DouyuClient;
import com.example.mixlive.client.douyu.catetab.CateTab;
import com.example.mixlive.client.douyu.newdirectory.CateListDTO;
import com.example.mixlive.client.douyu.newdirectory.ListDTO;
import com.example.mixlive.client.douyu.newdirectory.NewDirectoryResponse;
import com.example.mixlive.jpa.PlatformCategory;
import com.example.mixlive.jpa.PlatformCategoryRepository;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.douyu.DouyuCategory;
import com.example.mixlive.model.category.douyu.DouyuSubCategory;
import com.example.mixlive.model.category.douyu.DouyuSubSubCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DouyuCategoryService {

    private final DouyuClient douyuClient;
    private final DouyuCategoryCacheService douyuCategoryCacheService;

    private final PlatformCategoryRepository platformCategoryRepository;


    public List<DouyuCategory> getFromCache() {
        return douyuCategoryCacheService.get();
    }

    public void putToCache(List<DouyuCategory> douyuCategories) {
        douyuCategoryCacheService.put(douyuCategories);
    }

    public void saveToDB(List<DouyuCategory> douyuCategories) {
        PlatformCategory platformCategory = PlatformCategory.builder()
                                                            .platformType(PlatformType.DOUYU)
                                                            .jsonContent(JSONUtil.toJsonStr(douyuCategories))
                                                            .build();
        platformCategoryRepository.save(platformCategory);
    }

    public boolean exists() {
        return platformCategoryRepository.existsByPlatformType(PlatformType.DOUYU);
    }

    public List<DouyuCategory> generate() {
        NewDirectoryResponse newDirectoryResponse = douyuClient.getNewDirectory();
        List<CateListDTO> cateListDTOs = newDirectoryResponse.getData().getLeftNav().getCateList();
        List<DouyuCategory> douyuCategories = StreamEx.of(cateListDTOs)
                                                      .map(this::toDouyuCategory)
                                                      .toList();

        return douyuCategories;
    }

    private DouyuCategory toDouyuCategory(CateListDTO cateListDTO) {
        List<DouyuSubCategory> douyuSubCategories =
                StreamEx.of(cateListDTO.getList())
                        .map(this::toDouyuSecondLevelCategory)
                        .toList();

        return DouyuCategory.builder()
                            .name(cateListDTO.getName())
                            .subCategories(douyuSubCategories)
                            .build();

    }

    private DouyuSubCategory toDouyuSecondLevelCategory(ListDTO listDTO) {
        List<DouyuSubSubCategory> thirdLevelCategories =
                StreamEx.of(douyuClient.getCateTabs(listDTO.getUrl()))
                        .map(this::toDouyuThirdLevelCategory)
                        .toList();

        DouyuSubSubCategory all = DouyuSubSubCategory.builder()
                                                     .name("全部")
                                                     .categoryLevelAndId("2_" + listDTO.getCid2())
                                                     .build();
        thirdLevelCategories.add(0, all);

        return DouyuSubCategory.builder()
                               .name(listDTO.getCn2())
                               .subSubCategories(thirdLevelCategories)
                               .build();
    }

    private DouyuSubSubCategory toDouyuThirdLevelCategory(CateTab cateTab) {
        return DouyuSubSubCategory.builder()
                                  .name(cateTab.getName())
                                  .categoryLevelAndId("3_" + cateTab.getCid())
                                  .build();
    }

}

