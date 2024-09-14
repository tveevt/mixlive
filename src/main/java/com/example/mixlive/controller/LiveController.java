package com.example.mixlive.controller;

import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.RoomWithUserInfo;
import com.example.mixlive.model.category.CategoryInfo;
import com.example.mixlive.service.category.CategoryInfoCacheService;
import com.example.mixlive.service.live.BiliLiveService;
import com.example.mixlive.service.live.DouyuLiveService;
import com.example.mixlive.service.live.LiveService;
import one.util.streamex.StreamEx;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;

@RestController
@RequestMapping
public class LiveController {

    private Map<PlatformType, LiveService> liveServiceByType;
    private CategoryInfoCacheService categoryInfoCacheService;

    public LiveController(CategoryInfoCacheService categoryInfoCacheService,
                          List<LiveService> liveServices) {
        this.categoryInfoCacheService = categoryInfoCacheService;
        this.liveServiceByType = StreamEx.of(liveServices).toMap(LiveService::getPlatformType, identity());
    }

    @GetMapping("/live/categoryInfos")
    public Map<PlatformType, List<CategoryInfo>> getLiveCategoryInfos() {
        return categoryInfoCacheService.getAll();
    }

    @GetMapping("/bilibili/category/roomInfos")
    public List<RoomWithUserInfo> getBiliRoomInfos(
            @RequestParam("parentAreaId") Integer parentAreaId,
            @RequestParam("areaId") Integer areaId,
            @RequestParam("sort_type") String sortType,
            @RequestParam("page") Integer page) {
        BiliLiveService biliLiveService = (BiliLiveService) liveServiceByType.get(PlatformType.bilibili);
        return biliLiveService.getRoomWithUserInfos(parentAreaId, areaId, sortType, page);
    }

    @GetMapping("/douyu/category/roomInfos")
    public List<RoomWithUserInfo> getDouyuRoomInfos(
            @RequestParam("categoryLevelAndId") String categoryLevelAndId,
            @RequestParam("page") Integer page) {
        DouyuLiveService douyuLiveService = (DouyuLiveService) liveServiceByType.get(PlatformType.douyu);
        return douyuLiveService.getRoomWithUserInfos(categoryLevelAndId, page);
    }

    @GetMapping("/{platformType}/search")
    public List<RoomWithUserInfo> search(
            @PathVariable("platformType") PlatformType platformType,
            @RequestParam("keyword") String keyword,
            @RequestParam("page") Integer page) {
        return liveServiceByType.get(platformType).search(keyword, page);
    }

    @GetMapping("/{platformType}/realUrl/{roomId}")
    public Map<Object, String> getRealUrl(
            @PathVariable("platformType") PlatformType platformType,
            @PathVariable("roomId") Integer roomId) {
        return liveServiceByType.get(platformType).getRealUrl(roomId);

    }

}   

    