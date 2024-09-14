package com.example.mixlive.service.live;

import com.example.mixlive.client.douyu.DouyuClient;
import com.example.mixlive.client.douyu.mixlistv1.MixListV1Response;
import com.example.mixlive.client.douyu.mixlistv1.RlDTO;
import com.example.mixlive.client.douyu.search.RelateShowDTO;
import com.example.mixlive.client.douyu.search.SearchShowResponse;
import com.example.mixlive.client.douyu.streamurl.StreamUrlResponse;
import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.RoomWithUserInfo;
import com.example.mixlive.service.live.convertor.DouyuLiveConvertor;
import lombok.AllArgsConstructor;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class DouyuLiveService implements LiveService {

    private final DouyuClient douyuClient;

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.douyu;
    }

    @Override
    public List<RoomWithUserInfo> search(String keyWords, Integer page) {
        SearchShowResponse searchShowResponse = douyuClient.search(keyWords, page);
        List<RelateShowDTO> relateShowDTOs = searchShowResponse.getData().getRelateShow();
        return DouyuLiveConvertor.toRoomWithUserInfosByRelateShowDTOs(relateShowDTOs);
    }

    @Override
    public Map<Object, String> getRealUrl(Integer roomId) {
        StreamUrlResponse streamUrl = douyuClient.getStreamUrl(roomId);
        String rateName = StreamEx.of(streamUrl.getData().getSettings())
                                  .filter(settingsDTO -> settingsDTO.getRate() == streamUrl.getData().getRate())
                                  .map(settingsDTO -> settingsDTO.getName())
                                  .findFirst()
                                  .get();

        Map<Object, String> rateNameToUrl = new HashMap<>();
        rateNameToUrl.put(rateName, streamUrl.getData().getUrl());
        return rateNameToUrl;
    }

    public List<RoomWithUserInfo> getRoomWithUserInfos(String categoryLevelAndId, Integer page) {
        MixListV1Response mixListV1Response = douyuClient.getMixListV1(categoryLevelAndId, page);
        List<RlDTO> rlDTOs = mixListV1Response.getData().getRl();
        return DouyuLiveConvertor.toRoomWithUserInfosByRlDTOs(rlDTOs);
    }

}
