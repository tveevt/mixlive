package com.example.mixlive.platform.douyu.convertor;

import com.example.mixlive.client.douyu.mixlistv1.RlDTO;
import com.example.mixlive.client.douyu.search.RelateShowDTO;
import com.example.mixlive.model.RoomDetail;
import com.example.mixlive.model.RoomWithUserDetail;
import com.example.mixlive.model.UserDetail;
import one.util.streamex.StreamEx;

import java.util.List;

public class DouyuLiveConvertor {

    public static List<RoomWithUserDetail> toRoomWithUserDetailsByRlDTOs(List<RlDTO> rlDTOs) {
        return StreamEx.of(rlDTOs)
                       .map(DouyuLiveConvertor::toRoomWithUserDetail)
                       .toList();
    }

    private static RoomWithUserDetail toRoomWithUserDetail(RlDTO rlDTO) {
        return RoomWithUserDetail.builder()
                                 .roomDetail(toRoomDetail(rlDTO))
                                 .userDetail(toUserDetail(rlDTO))
                                 .build();
    }

    private static RoomDetail toRoomDetail(RlDTO rlDTO) {
        return RoomDetail.builder()
                         .id(rlDTO.getRid())
                         .title(rlDTO.getRn())
                         .coverUrl(rlDTO.getRs16())
                         .categoryName(rlDTO.getC2name())
                         .hot(String.valueOf(rlDTO.getOl()))
                         .build();
    }

    private static UserDetail toUserDetail(RlDTO rlDTO) {
        return UserDetail.builder()
                         .id(rlDTO.getUid())
                         .username(rlDTO.getNn())
                         .avatarUrl(rlDTO.getAv())
                         .build();
    }

    public static List<RoomWithUserDetail> toRoomWithUserDetailsByRelateShowDTOs(List<RelateShowDTO> relateShowDTOs) {
        return StreamEx.of(relateShowDTOs)
                       .map(DouyuLiveConvertor::toRoomWithUserDetail)
                       .toList();
    }

    private static RoomWithUserDetail toRoomWithUserDetail(RelateShowDTO relateShowDTO) {
        return RoomWithUserDetail.builder()
                                 .roomDetail(toRoomDetail(relateShowDTO))
                                 .userDetail(toUserDetail(relateShowDTO))
                                 .build();
    }

    private static RoomDetail toRoomDetail(RelateShowDTO relateShowDTO) {
        return RoomDetail.builder()
                         .id(relateShowDTO.getRid())
                         .title(relateShowDTO.getRoomName())
                         .coverUrl(relateShowDTO.getRoomSrc())
                         .categoryName(relateShowDTO.getCateName())
                         .hot(relateShowDTO.getHot())
                         .build();
    }

    private static UserDetail toUserDetail(RelateShowDTO relateShowDTO) {
        return UserDetail.builder()
                         .id(Long.parseLong(relateShowDTO.getAlgorithm().getToUid()))
                         .username(relateShowDTO.getNickName())
                         .avatarUrl(relateShowDTO.getAvatar())
                         .build();
    }

}
