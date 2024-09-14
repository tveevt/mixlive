package com.example.mixlive.service.live.convertor;

import com.example.mixlive.client.bilibili.livestreamlist.ListDTO;
import com.example.mixlive.client.bilibili.roomplayinfo.CodecDTO;
import com.example.mixlive.client.bilibili.roomplayinfo.FormatDTO;
import com.example.mixlive.client.bilibili.roomplayinfo.RoomPlayInfoResponse;
import com.example.mixlive.client.bilibili.roomplayinfo.StreamDTO;
import com.example.mixlive.client.bilibili.search.LiveRoomDTOX;
import com.example.mixlive.model.RoomInfo;
import com.example.mixlive.model.RoomWithUserInfo;
import com.example.mixlive.model.UserInfo;
import one.util.streamex.StreamEx;

import java.util.List;
import java.util.Map;

public class BiliLiveConvertor {

    private static RoomInfo toRoomInfo(ListDTO listDTO) {
        return RoomInfo.builder()
                       .id(listDTO.getRoomid())
                       .title(listDTO.getTitle())
                       .coverUrl(listDTO.getCover())
                       .categoryName(listDTO.getAreaName())
                       .hot(listDTO.getWatchedShow().getTextSmall())
                       .build();
    }

    private static UserInfo toUserInfo(ListDTO listDTO) {
        return UserInfo.builder()
                       .id(listDTO.getUid())
                       .username(listDTO.getUname())
                       .userAvatarUrl(listDTO.getUserCover())
                       .build();
    }

    public static RoomWithUserInfo toRoomInfoWithUserInfo(ListDTO listDTO) {
        return RoomWithUserInfo.builder()
                               .roomInfo(toRoomInfo(listDTO))
                               .userInfo(toUserInfo(listDTO))
                               .build();
    }

    private static RoomInfo toRoomInfo(LiveRoomDTOX liveRoomDTOX) {
        return RoomInfo.builder()
                       .id(liveRoomDTOX.getRoomid())
                       .title(replaceUnnecessaryCharacter(liveRoomDTOX.getTitle()))
                       .coverUrl(liveRoomDTOX.getCover())
                       .categoryName(liveRoomDTOX.getCateName())
                       .hot(liveRoomDTOX.getWatchedShow().getTextSmall())
                       .build();
    }

    private static String replaceUnnecessaryCharacter(String title) {
        return title.replace("<em class=\"keyword\">", "").replace("</em>", "");
    }

    private static UserInfo toUserInfo(LiveRoomDTOX liveRoomDTOX) {
        return UserInfo.builder()
                       .id(liveRoomDTOX.getUid())
                       .username(liveRoomDTOX.getUname())
                       .userAvatarUrl(liveRoomDTOX.getUserCover())
                       .build();
    }

    public static RoomWithUserInfo toRoomWithUserInfo(LiveRoomDTOX liveRoomDTOX) {
        return RoomWithUserInfo.builder()
                               .roomInfo(toRoomInfo(liveRoomDTOX))
                               .userInfo(toUserInfo(liveRoomDTOX))
                               .build();
    }

    public static Map<Object, String> toRealUrl(RoomPlayInfoResponse roomPlayInfoResponse) {
        List<StreamDTO> streamDTOs = roomPlayInfoResponse.getData().getPlayurlInfo().getPlayurl().getStream();
        StreamDTO streamDTO = StreamEx.of(streamDTOs)
                                      .reduce((first, second) -> second)
                                      .orElse(null);
        List<FormatDTO> formatDTOs = streamDTO.getFormat();
        FormatDTO format = StreamEx.of(formatDTOs)
                                   .reduce((first, second) -> second)
                                   .orElse(null);

        List<CodecDTO> codecDTOs = format.getCodec();
        return StreamEx.of(codecDTOs)
                       .toMap(CodecDTO::getCurrentQn, BiliLiveConvertor::toRealUrl, (oldValue, newValue) -> newValue);
    }

    public static String toRealUrl(CodecDTO codecDTO) {
        String baseUrl = codecDTO.getBaseUrl();
        String realUrl = StreamEx.of(codecDTO.getUrlInfo())
                                 .reduce((first, second) -> second)
                                 .map(urlInfo -> buildRealUrl(urlInfo.getHost(), baseUrl, urlInfo.getExtra()))
                                 .orElse("");

        return realUrl;
    }

    private static String buildRealUrl(String host, String baseUrl, String extra) {
        return new StringBuilder(host)
                .append(baseUrl)
                .append(extra)
                .toString();
    }
}
