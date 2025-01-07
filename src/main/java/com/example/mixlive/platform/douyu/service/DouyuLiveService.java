package com.example.mixlive.platform.douyu.service;

import com.example.mixlive.client.douyu.DouyuClient;
import com.example.mixlive.client.douyu.mixlistv1.MixListV1Response;
import com.example.mixlive.client.douyu.mixlistv1.RlDTO;
import com.example.mixlive.client.douyu.search.RelateShowDTO;
import com.example.mixlive.client.douyu.search.SearchShowResponse;
import com.example.mixlive.client.douyu.streamurl.StreamUrlResponse;
import com.example.mixlive.model.RoomWithUserDetail;
import com.example.mixlive.model.category.douyu.DouyuCategory;
import com.example.mixlive.platform.douyu.convertor.DouyuLiveConvertor;
import lombok.AllArgsConstructor;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class DouyuLiveService {

    private final DouyuClient douyuClient;

    private final DouyuCategoryService douyuCategoryService;

    public List<DouyuCategory> getCategories() {
        return douyuCategoryService.getFromCache();
    }

    public List<DouyuCategory> generateCategories() {
        return douyuCategoryService.generate();
    }

    public void saveCategoriesToDB(List<DouyuCategory> categories) {
        douyuCategoryService.saveToDB(categories);
    }

    public void putCategoriesToCache(List<DouyuCategory> douyuCategories) {
        douyuCategoryService.putToCache(douyuCategories);
    }

    public boolean existsCategories() {
        return douyuCategoryService.exists();
    }

    public List<RoomWithUserDetail> getRoomWithUserInfos(String categoryLevelAndId, Integer page) {
        MixListV1Response mixListV1Response = douyuClient.getMixListV1(categoryLevelAndId, page);
        List<RlDTO> rlDTOs = mixListV1Response.getData().getRl();
        return DouyuLiveConvertor.toRoomWithUserDetailsByRlDTOs(rlDTOs);
    }

    public List<RoomWithUserDetail> search(String keyWords, Integer page) {
        SearchShowResponse searchShowResponse = douyuClient.search(keyWords, page);
        List<RelateShowDTO> relateShowDTOs = searchShowResponse.getData().getRelateShow();
        return DouyuLiveConvertor.toRoomWithUserDetailsByRelateShowDTOs(relateShowDTOs);
    }

    public Map<String, String> getQualityStreamUrlMap(Integer roomId) {
        StreamUrlResponse streamUrl = douyuClient.getStreamUrl(roomId);
        String rateName = StreamEx.of(streamUrl.getData().getSettings())
                                  .filter(settingsDTO -> settingsDTO.getRate() == streamUrl.getData()
                                                                                           .getRate())
                                  .map(settingsDTO -> settingsDTO.getName())
                                  .findFirst()
                                  .orElseThrow(() -> new IllegalArgumentException("rate not found for roomId " + roomId));

        return Collections.singletonMap(rateName, streamUrl.getData().getUrl());
    }


}
