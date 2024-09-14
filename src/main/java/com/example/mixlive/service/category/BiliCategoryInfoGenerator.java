package com.example.mixlive.service.category;

import com.example.mixlive.client.bilibili.BiliClient;
import com.example.mixlive.client.bilibili.livestreamlist.LiveStreamListResponse;
import com.example.mixlive.client.bilibili.livestreamlist.NewTagsDTO;
import com.example.mixlive.client.bilibili.webarealist.DataDTO;
import com.example.mixlive.client.bilibili.webarealist.ListDTO;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.CategoryInfo;
import com.example.mixlive.model.category.bilibili.BiliCategoryInfo;
import com.example.mixlive.model.category.bilibili.BiliSubCategoryInfo;
import com.example.mixlive.model.category.bilibili.SortTagInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BiliCategoryInfoGenerator implements CategoryInfoGenerator {

    private final BiliClient biliClient;

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.bilibili;
    }

    @Override
    public List<CategoryInfo> generate() {
        //if(true) return new ArrayList<>();
        List<DataDTO> parentAndChildAreaInfos = biliClient.getWebAreaList().getData().getData();

        List<BiliCategoryInfo> biliCategoryInfos = StreamEx.of(parentAndChildAreaInfos)
                                                           .map(this::toBiliCategoryInfo)
                                                           .toList();
        return new ArrayList<>(biliCategoryInfos);

    }

    private BiliCategoryInfo toBiliCategoryInfo(DataDTO category) {
        List<BiliSubCategoryInfo> subCategoryInfos = StreamEx.of(category.getList())
                                                             .map(this::toBiliSubCategoryInfo)
                                                             .toList();
        return BiliCategoryInfo.builder()
                               .id(category.getId())
                               .name(category.getName())
                               .subCategoryInfos(subCategoryInfos)
                               .build();
    }

    private BiliSubCategoryInfo toBiliSubCategoryInfo(ListDTO listDTO) {
        Integer parentAreaId = Integer.parseInt(listDTO.getParentId());
        Integer areaId = Integer.parseInt(listDTO.getId());

        List<SortTagInfo> sortTags = fetchNewTags(parentAreaId, areaId);

        return BiliSubCategoryInfo.builder()
                                  .name(listDTO.getName())
                                  .areaId(listDTO.getId())
                                  .sortTags(sortTags)
                                  .build();
    }

    private List<SortTagInfo> fetchNewTags(Integer parentAreaId, Integer areaId) {
        LiveStreamListResponse liveStreamListResponse = biliClient.getLiveStreamList(parentAreaId, areaId);
        List<NewTagsDTO> newTags = liveStreamListResponse.getData().getNewTags();
        log.info("Fetched newTags size: {} parentAreaId: {}, areaId: {}", newTags.size(), parentAreaId, areaId);

        return StreamEx.of(newTags)
                       .map(this::toSortTagInfo)
                       .toList();
    }

    private SortTagInfo toSortTagInfo(NewTagsDTO newTagsDTO) {
        return SortTagInfo.builder()
                          .name(newTagsDTO.getName())
                          .sortType(newTagsDTO.getSortType())
                          .build();
    }

}
