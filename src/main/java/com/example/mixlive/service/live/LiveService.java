package com.example.mixlive.service.live;

import com.example.mixlive.model.PlatformType;
import com.example.mixlive.model.RoomWithUserInfo;

import java.util.List;
import java.util.Map;

public interface LiveService {

    PlatformType getPlatformType();

    default boolean isSupport(PlatformType platformType) {
        return getPlatformType().equals(platformType);
    }

    List<RoomWithUserInfo> search(String keyWords, Integer page);

    Map<Object, String> getRealUrl(Integer roomId);
}
