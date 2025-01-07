package com.example.mixlive.platform.bilibili.service;

import cn.hutool.json.JSONUtil;
import com.example.mixlive.client.bilibili.BiliClient;
import com.example.mixlive.client.bilibili.livestreamlist.LiveStreamListResponse;
import com.example.mixlive.client.bilibili.livestreamlist.NewTagsDTO;
import com.example.mixlive.client.bilibili.webarealist.DataDTO;
import com.example.mixlive.client.bilibili.webarealist.ListDTO;
import com.example.mixlive.jpa.PlatformCategory;
import com.example.mixlive.jpa.PlatformCategoryRepository;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.category.bilibili.BiliCategory;
import com.example.mixlive.model.category.bilibili.BiliSubCategory;
import com.example.mixlive.model.category.bilibili.SortTagInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BiliCategoryService {

    private final BiliClient biliClient;

    private final BiliCategoryCacheService biliCategoryCacheService;

    private final PlatformCategoryRepository platformCategoryRepository;


    public List<BiliCategory> getFromCache() {
        return biliCategoryCacheService.get();
    }

    public void putToCache(List<BiliCategory> categories) {
        biliCategoryCacheService.put(categories);
    }

    public void saveToDB(List<BiliCategory> categories) {
        PlatformCategory platformCategory = PlatformCategory.builder()
                                                            .platformType(PlatformType.BILIBILI)
                                                            .jsonContent(JSONUtil.toJsonStr(categories))
                                                            .build();
        platformCategoryRepository.save(platformCategory);
    }

    public boolean exists() {
        return platformCategoryRepository.existsByPlatformType(PlatformType.BILIBILI);
    }

    public List<BiliCategory> generate() {
        List<DataDTO> parentAndChildAreaInfos = biliClient.getWebAreaList().getData().getData();

        List<BiliCategory> biliCategories = StreamEx.of(parentAndChildAreaInfos)
                                                    .map(this::toBiliCategory)
                                                    .toList();
        return biliCategories;

    }

    private BiliCategory toBiliCategory(DataDTO category) {
        List<BiliSubCategory> biliSubCategories = StreamEx.of(category.getList())
                                                          .map(this::toBiliSubCategory)
                                                          .toList();
        return BiliCategory.builder()
                           .id(category.getId())
                           .name(category.getName())
                           .subCategories(biliSubCategories)
                           .build();
    }

    private BiliSubCategory toBiliSubCategory(ListDTO listDTO) {
        Integer parentAreaId = Integer.parseInt(listDTO.getParentId());
        Integer areaId = Integer.parseInt(listDTO.getId());

        List<SortTagInfo> sortTags = fetchNewTags(parentAreaId, areaId);

        return BiliSubCategory.builder()
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
