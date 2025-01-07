package com.example.mixlive.platform.bilibili;

import com.example.mixlive.model.RoomWithUserDetail;
import com.example.mixlive.model.category.bilibili.BiliCategory;
import com.example.mixlive.platform.bilibili.service.BiliLiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bilibili")
@RequiredArgsConstructor
public class BiliLiveController {

    private final BiliLiveService biliLiveService;

    @GetMapping("/categories")
    public List<BiliCategory> getCategories() {
        return biliLiveService.getCategories();
    }

    @GetMapping("/roomInfos")
    public List<RoomWithUserDetail> getRoomInfos(
            @RequestParam("parentAreaId") Integer parentAreaId,
            @RequestParam("areaId") Integer areaId,
            @RequestParam("sort_type") String sortType,
            @RequestParam("page") Integer page) {
        return biliLiveService.getRoomWithUserInfos(parentAreaId, areaId, sortType, page);
    }

    @GetMapping("/search")
    public List<RoomWithUserDetail> search(
            @RequestParam("keyword") String keyword,
            @RequestParam("page") Integer page) {
        return biliLiveService.search(keyword, page);
    }

    @GetMapping("/stream-url/{roomId}")
    public Map<String, String> getStreamUrl(
            @PathVariable("roomId") Integer roomId) {
        return biliLiveService.getQualityStreamUrlMap(roomId);

    }


}
