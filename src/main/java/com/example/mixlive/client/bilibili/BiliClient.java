package com.example.mixlive.client.bilibili;

import cn.hutool.json.JSONUtil;
import com.example.mixlive.client.bilibili.livestreamlist.LiveStreamListResponse;
import com.example.mixlive.client.bilibili.playurl.PlayUrlResponse;
import com.example.mixlive.client.bilibili.roomplayinfo.RoomPlayInfoResponse;
import com.example.mixlive.client.bilibili.search.SearchResponse;
import com.example.mixlive.client.bilibili.webarealist.WebAreaListResponse;
import com.example.mixlive.platform.bilibili.convertor.BiliLiveConvertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
public class BiliClient {
    private final RestTemplate restTemplate;

    public WebAreaListResponse getWebAreaList() {
        //https://api.live.bilibili.com/xlive/web-interface/v1/index/getWebAreaList?source_id=2
        String url = "https://api.live.bilibili.com/xlive/web-interface/v1/index/getWebAreaList?source_id=2";
        return restTemplate.getForObject(url, WebAreaListResponse.class);
    }

    public LiveStreamListResponse getLiveStreamList(Integer parentAreaId, Integer areaId) {
        return getLiveStreamList(parentAreaId, areaId, null, 1);
    }

    public LiveStreamListResponse getLiveStreamList(Integer parentAreaId, Integer areaId, String sortType, Integer page) {
        String baseUrl = "https://api.live.bilibili.com/xlive/web-interface/v1/second/getList";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                         .queryParam("platform", "web")
                                         .queryParam("parent_area_id", parentAreaId)
                                         .queryParam("area_id", areaId)
                                         .queryParam("sort_type", sortType) // 如果不需要排序，可以传入 null 或 ""
                                         .queryParam("page", page)
                                         .toUriString();

        return restTemplate.getForObject(url, LiveStreamListResponse.class);
    }

    public SearchResponse search(String keyword, Integer page) {
        //https://api.bilibili.com/x/web-interface/search/type?search_type=live&keyword=lol&page=1
        String baseUrl = "https://api.bilibili.com/x/web-interface/search/type";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                         .queryParam("search_type", "live")
                                         .queryParam("keyword", keyword)
                                         .queryParam("page", page)
                                         .toUriString();

        HttpHeaders headers = new HttpHeaders();

        //must set Cookie header, value is unnecessary
        headers.set("Cookie", null);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<SearchResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, SearchResponse.class);

        return response.getBody();
    }


    //从response中构建的部分stream-url长期有效但不支持较高画质
    public RoomPlayInfoResponse getRoomPlayInfo(Integer roomId) {
        String baseUrl = "https://api.live.bilibili.com/xlive/web-room/v2/index/getRoomPlayInfo";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                         .queryParam("room_id", roomId)
                                         .queryParam("protocol", "0,1")
                                         .queryParam("format", "0,1,2")
                                         .queryParam("codec", "0,1,2")
                                         .queryParam("platform", "web")
                                         .toUriString();

        return restTemplate.getForObject(url, RoomPlayInfoResponse.class);
    }

    public PlayUrlResponse getPlayUrl(Integer roomId) {
        return getPlayUrl(roomId, 4);
    }


    //从response中构建的stream-url短期有效并支持更高画质 重新开播后应该重新获取
    public PlayUrlResponse getPlayUrl(Integer roomId, int qn) {
        String baseUrl = "https://api.live.bilibili.com/room/v1/Room/playUrl";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                         .queryParam("cid", roomId)
                                         .queryParam("qn", qn)
                                         .queryParam("platform", "web")
                                         .toUriString();
        return restTemplate.getForObject(url, PlayUrlResponse.class);
    }

    public static void main(String[] args) {
        BiliClient biliClient = new BiliClient(new RestTemplate());
        int roomId = 21669525;
        RoomPlayInfoResponse roomPlayInfoResponse = biliClient.getRoomPlayInfo(roomId);

        //log.info(String.valueOf(roomPlayInfoResponse));
        log.info(JSONUtil.toJsonStr(roomPlayInfoResponse));
        BiliLiveConvertor.toQualityStreamUrlsMap(roomPlayInfoResponse)
                         .forEach((k, v) -> {
                             System.out.println(k + " size: " + v.size());
                             v.forEach(System.out::println);
                         });

        //PlayUrlResponse playUrl = biliClient.getPlayUrl(roomId);
        //playUrl.getData().getDurl().forEach(durlDTO -> {
        //    System.out.println(durlDTO.getUrl());
        //});
    }

}
