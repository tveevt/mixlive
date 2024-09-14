package com.example.mixlive.client.bilibili;

import com.example.mixlive.client.bilibili.livestreamlist.LiveStreamListResponse;
import com.example.mixlive.client.bilibili.roomplayinfo.RoomPlayInfoResponse;
import com.example.mixlive.client.bilibili.search.SearchResponse;
import com.example.mixlive.client.bilibili.webarealist.WebAreaListResponse;
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

    public static void main(String[] args) {
        BiliClient biliClient = new BiliClient(new RestTemplate());
        RoomPlayInfoResponse roomPlayInfoResponse = biliClient.getRoomPlayInfo(21669525);
        log.info(String.valueOf(roomPlayInfoResponse));
    }

}
