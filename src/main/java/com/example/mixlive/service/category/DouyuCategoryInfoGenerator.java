package com.example.mixlive.service.category;

import com.example.mixlive.client.douyu.DouyuClient;
import com.example.mixlive.client.douyu.catetab.CateTab;
import com.example.mixlive.client.douyu.newdirectory.CateListDTO;
import com.example.mixlive.client.douyu.newdirectory.ListDTO;
import com.example.mixlive.client.douyu.newdirectory.NewDirectoryResponse;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.CategoryInfo;
import com.example.mixlive.model.category.douyu.DouyuCategoryInfo;
import com.example.mixlive.model.category.douyu.DouyuSubCategoryInfo;
import com.example.mixlive.model.category.douyu.DouyuSubSubCategoryInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DouyuCategoryInfoGenerator implements CategoryInfoGenerator {

    private final DouyuClient douyuClient;

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.douyu;
    }

    @Override
    public List<CategoryInfo> generate() {
        NewDirectoryResponse newDirectoryResponse = douyuClient.getNewDirectory();
        List<CateListDTO> cateListDTOs = newDirectoryResponse.getData().getLeftNav().getCateList();
        List<DouyuCategoryInfo> douyuCategoryInfos = StreamEx.of(cateListDTOs)
                                                             .map(this::toDouyuCategoryInfo)
                                                             .toList();

        return new ArrayList<>(douyuCategoryInfos);
    }

    private DouyuCategoryInfo toDouyuCategoryInfo(CateListDTO cateListDTO) {
        List<DouyuSubCategoryInfo> douyuSubCategoryInfos =
                StreamEx.of(cateListDTO.getList())
                        .map(this::toDouyuSecondLevelCategoryInfo)
                        .toList();

        return DouyuCategoryInfo.builder()
                                .name(cateListDTO.getName())
                                .subCategoryInfos(douyuSubCategoryInfos)
                                .build();

    }

    private DouyuSubCategoryInfo toDouyuSecondLevelCategoryInfo(ListDTO listDTO) {
        List<DouyuSubSubCategoryInfo> thirdLevelCategoryInfos =
                StreamEx.of(douyuClient.getCateTabs(listDTO.getUrl()))
                        .map(this::toDouyuThirdLevelCategoryInfo)
                        .toList();

        DouyuSubSubCategoryInfo all = DouyuSubSubCategoryInfo.builder()
                                                             .name("全部")
                                                             .categoryLevelAndId("2_" + listDTO.getCid2())
                                                             .build();
        thirdLevelCategoryInfos.add(0, all);

        return DouyuSubCategoryInfo.builder()
                                   .name(listDTO.getCn2())
                                   .subSubCategoryInfos(thirdLevelCategoryInfos)
                                   .build();
    }

    private DouyuSubSubCategoryInfo toDouyuThirdLevelCategoryInfo(CateTab cateTab) {
        return DouyuSubSubCategoryInfo.builder()
                                      .name(cateTab.getName())
                                      .categoryLevelAndId("3_" + cateTab.getCid())
                                      .build();
    }

}

