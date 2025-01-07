package com.example.mixlive.platform.douyu;

import com.example.mixlive.model.RoomWithUserDetail;
import com.example.mixlive.model.category.douyu.DouyuCategory;
import com.example.mixlive.platform.douyu.service.DouyuLiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/douyu")
@RequiredArgsConstructor
public class DouyuLiveController {

    private final DouyuLiveService douyuLiveService;

    @GetMapping("/categories")
    public List<DouyuCategory> getCategories() {
        return douyuLiveService.getCategories();
    }

    @GetMapping("/roomInfos")
    public List<RoomWithUserDetail> getRoomInfos(
            @RequestParam("categoryLevelAndId") String categoryLevelAndId,
            @RequestParam("page") Integer page) {
        return douyuLiveService.getRoomWithUserInfos(categoryLevelAndId, page);
    }

    @GetMapping("/search")
    public List<RoomWithUserDetail> search(
            @RequestParam("keyword") String keyword,
            @RequestParam("page") Integer page) {
        return douyuLiveService.search(keyword, page);
    }

    @GetMapping("/stream-url/{roomId}")
    public Map<String, String> getStreamUrl(
            @PathVariable("roomId") Integer roomId) {
        return douyuLiveService.getQualityStreamUrlMap(roomId);

    }


}
