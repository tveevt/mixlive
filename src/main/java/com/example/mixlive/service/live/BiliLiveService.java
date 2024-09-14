package com.example.mixlive.service.live;

import com.example.mixlive.client.bilibili.BiliClient;
import com.example.mixlive.client.bilibili.livestreamlist.ListDTO;
import com.example.mixlive.client.bilibili.livestreamlist.LiveStreamListResponse;
import com.example.mixlive.client.bilibili.roomplayinfo.RoomPlayInfoResponse;
import com.example.mixlive.client.bilibili.search.LiveRoomDTOX;
import com.example.mixlive.client.bilibili.search.SearchResponse;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.RoomWithUserInfo;
import com.example.mixlive.service.live.convertor.BiliLiveConvertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BiliLiveService implements LiveService {

    private final BiliClient biliClient;

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.bilibili;
    }

    public List<RoomWithUserInfo> getRoomWithUserInfos(Integer parentAreaId, Integer areaId, String sortType, Integer page) {
        LiveStreamListResponse liveStreamListResponse = biliClient.getLiveStreamList(parentAreaId, areaId, sortType, page);
        List<ListDTO> listDTOs = liveStreamListResponse.getData().getList();
        return StreamEx.of(listDTOs)
                       .map(BiliLiveConvertor::toRoomInfoWithUserInfo)
                       .toList();
    }

    @Override
    public List<RoomWithUserInfo> search(String keyWords, Integer page) {
        SearchResponse searchResponse = biliClient.search(keyWords, page);
        List<LiveRoomDTOX> liveRoomDTOXs = searchResponse.getData().getResult().getLiveRoom();
        return StreamEx.of(liveRoomDTOXs)
                       .map(BiliLiveConvertor::toRoomWithUserInfo)
                       .toList();
    }

    @Override
    public Map<Object, String> getRealUrl(Integer roomId) {
        RoomPlayInfoResponse roomPlayInfoResponse = biliClient.getRoomPlayInfo(roomId);
        return BiliLiveConvertor.toRealUrl(roomPlayInfoResponse);
    }

}
