package com.example.mixlive.service.live.convertor;

import com.example.mixlive.client.douyu.mixlistv1.RlDTO;
import com.example.mixlive.client.douyu.search.RelateShowDTO;
import com.example.mixlive.model.RoomInfo;
import com.example.mixlive.model.RoomWithUserInfo;
import com.example.mixlive.model.UserInfo;
import one.util.streamex.StreamEx;

import java.util.List;

public class DouyuLiveConvertor {

    public static List<RoomWithUserInfo> toRoomWithUserInfosByRlDTOs(List<RlDTO> rlDTOs) {
        return StreamEx.of(rlDTOs)
                       .map(DouyuLiveConvertor::toRoomWithUserInfo)
                       .toList();
    }

    private static RoomWithUserInfo toRoomWithUserInfo(RlDTO rlDTO) {
        return RoomWithUserInfo.builder()
                               .roomInfo(toRoomInfo(rlDTO))
                               .userInfo(toUserInfo(rlDTO))
                               .build();
    }

    private static RoomInfo toRoomInfo(RlDTO rlDTO) {
        return RoomInfo.builder()
                       .id(rlDTO.getRid())
                       .title(rlDTO.getRn())
                       .coverUrl(rlDTO.getRs16())
                       .categoryName(rlDTO.getC2name())
                       .hot(String.valueOf(rlDTO.getOl()))
                       .build();
    }

    private static UserInfo toUserInfo(RlDTO rlDTO) {
        return UserInfo.builder()
                       .id(rlDTO.getUid())
                       .username(rlDTO.getNn())
                       .userAvatarUrl(rlDTO.getAv())
                       .build();
    }

    public static List<RoomWithUserInfo> toRoomWithUserInfosByRelateShowDTOs(List<RelateShowDTO> relateShowDTOs) {
        return StreamEx.of(relateShowDTOs)
                       .map(DouyuLiveConvertor::toRoomWithUserInfo)
                       .toList();
    }

    private static RoomWithUserInfo toRoomWithUserInfo(RelateShowDTO relateShowDTO) {
        return RoomWithUserInfo.builder()
                               .roomInfo(toRoomInfo(relateShowDTO))
                               .userInfo(toUserInfo(relateShowDTO))
                               .build();
    }

    private static RoomInfo toRoomInfo(RelateShowDTO relateShowDTO) {
        return RoomInfo.builder()
                       .id(relateShowDTO.getRid())
                       .title(relateShowDTO.getRoomName())
                       .coverUrl(relateShowDTO.getRoomSrc())
                       .categoryName(relateShowDTO.getCateName())
                       .hot(relateShowDTO.getHot())
                       .build();
    }

    private static UserInfo toUserInfo(RelateShowDTO relateShowDTO) {
        return UserInfo.builder()
                       .id(Long.parseLong(relateShowDTO.getAlgorithm().getToUid()))
                       .username(relateShowDTO.getNickName())
                       .userAvatarUrl(relateShowDTO.getAvatar())
                       .build();
    }

}
