package com.example.mixlive.platform.bilibili.service;

import com.example.mixlive.client.bilibili.BiliClient;
import com.example.mixlive.client.bilibili.livestreamlist.ListDTO;
import com.example.mixlive.client.bilibili.livestreamlist.LiveStreamListResponse;
import com.example.mixlive.client.bilibili.roomplayinfo.RoomPlayInfoResponse;
import com.example.mixlive.client.bilibili.search.LiveRoomDTOX;
import com.example.mixlive.client.bilibili.search.SearchResponse;
import com.example.mixlive.model.RoomWithUserDetail;
import com.example.mixlive.model.category.bilibili.BiliCategory;
import com.example.mixlive.platform.bilibili.convertor.BiliLiveConvertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BiliLiveService {

    private final BiliClient biliClient;

    private final BiliCategoryService biliCategoryService;

    public List<BiliCategory> getCategories() {
        return biliCategoryService.getFromCache();
    }

    public List<BiliCategory> generateCategories() {
        return biliCategoryService.generate();
    }

    public void saveCategoriesToDB(List<BiliCategory> categories) {
        biliCategoryService.saveToDB(categories);
    }

    public void putCategoriesToCache(List<BiliCategory> biliCategories) {
        biliCategoryService.putToCache(biliCategories);
    }

    public boolean existsCategories() {
        return biliCategoryService.exists();
    }

    public List<RoomWithUserDetail> getRoomWithUserInfos(Integer parentAreaId, Integer areaId, String sortType, Integer page) {
        LiveStreamListResponse liveStreamListResponse = biliClient.getLiveStreamList(parentAreaId, areaId, sortType, page);
        List<ListDTO> listDTOs = liveStreamListResponse.getData().getList();
        return StreamEx.of(listDTOs)
                       .map(BiliLiveConvertor::toRoomWithUserDetail)
                       .toList();
    }

    public List<RoomWithUserDetail> search(String keyWords, Integer page) {
        SearchResponse searchResponse = biliClient.search(keyWords, page);
        List<LiveRoomDTOX> liveRoomDTOXs = searchResponse.getData().getResult().getLiveRoom();
        return StreamEx.of(liveRoomDTOXs)
                       .map(BiliLiveConvertor::toRoomWithUserDetail)
                       .toList();
    }

    public Map<String, String> getQualityStreamUrlMap(Integer roomId) {
        RoomPlayInfoResponse roomPlayInfoResponse = biliClient.getRoomPlayInfo(roomId);
        return BiliLiveConvertor.toQualityStreamUrlMap(roomPlayInfoResponse);
    }

}
