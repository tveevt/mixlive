package com.example.mixlive.platform.bilibili.convertor;

import com.example.mixlive.client.bilibili.livestreamlist.ListDTO;
import com.example.mixlive.client.bilibili.roomplayinfo.*;
import com.example.mixlive.client.bilibili.search.LiveRoomDTOX;
import com.example.mixlive.model.RoomDetail;
import com.example.mixlive.model.RoomWithUserDetail;
import com.example.mixlive.model.UserDetail;
import one.util.streamex.StreamEx;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BiliLiveConvertor {

    private static RoomDetail toRoomDetail(ListDTO listDTO) {
        return RoomDetail.builder()
                         .id(listDTO.getRoomid())
                         .title(listDTO.getTitle())
                         .coverUrl(listDTO.getCover())
                         .categoryName(listDTO.getAreaName())
                         .hot(listDTO.getWatchedShow().getTextSmall())
                         .build();
    }

    private static UserDetail toUserDetail(ListDTO listDTO) {
        return UserDetail.builder()
                         .id(listDTO.getUid())
                         .username(listDTO.getUname())
                         .avatarUrl(listDTO.getUserCover())
                         .build();
    }

    public static RoomWithUserDetail toRoomWithUserDetail(ListDTO listDTO) {
        return RoomWithUserDetail.builder()
                                 .roomDetail(toRoomDetail(listDTO))
                                 .userDetail(toUserDetail(listDTO))
                                 .build();
    }

    private static RoomDetail toRoomDetail(LiveRoomDTOX liveRoomDTOX) {
        return RoomDetail.builder()
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

    private static UserDetail toUserDetail(LiveRoomDTOX liveRoomDTOX) {
        return UserDetail.builder()
                         .id(liveRoomDTOX.getUid())
                         .username(liveRoomDTOX.getUname())
                         .avatarUrl(liveRoomDTOX.getUserCover())
                         .build();
    }

    public static RoomWithUserDetail toRoomWithUserDetail(LiveRoomDTOX liveRoomDTOX) {
        return RoomWithUserDetail.builder()
                                 .roomDetail(toRoomDetail(liveRoomDTOX))
                                 .userDetail(toUserDetail(liveRoomDTOX))
                                 .build();
    }

    public static Map<String, String> toQualityStreamUrlMap(RoomPlayInfoResponse roomPlayInfoResponse) {
        PlayurlInfoDTO playurlInfoDTO = roomPlayInfoResponse.getData().getPlayurlInfo();
        if (playurlInfoDTO == null) {
            return Collections.emptyMap();
        }

        StreamDTO streamDTO = getLastStream(playurlInfoDTO);
        FormatDTO format = getLastFormat(streamDTO);

        return StreamEx.of(format.getCodec())
                       .toMap(codecDTO -> buildQualityName(streamDTO, format, codecDTO),
                               codecDTO -> buildLastStreamUrl(codecDTO),
                               (oldValue, newValue) -> newValue);
    }

    private static FormatDTO getLastFormat(StreamDTO streamDTO) {
        return StreamEx.of(streamDTO.getFormat())
                       .reduce((first, second) -> second)
                       .orElse(null);
    }

    private static StreamDTO getLastStream(PlayurlInfoDTO playurlInfoDTO) {
        return StreamEx.of(playurlInfoDTO.getPlayurl().getStream())
                       .reduce((first, second) -> second)
                       .orElse(null);
    }

    public static String buildLastStreamUrl(CodecDTO codecDTO) {
        String baseUrl = codecDTO.getBaseUrl();

        return StreamEx.of(codecDTO.getUrlInfo())
                       .reduce((first, second) -> second)
                       .map(urlInfo -> buildStreamUrl(urlInfo.getHost(), baseUrl, urlInfo.getExtra()))
                       .orElse("");
    }

    public static Map<String, List<String>> toQualityStreamUrlsMap(RoomPlayInfoResponse roomPlayInfoResponse) {
        PlayurlInfoDTO playurlInfoDTO = roomPlayInfoResponse.getData().getPlayurlInfo();
        if (playurlInfoDTO == null) {
            return Collections.emptyMap();
        }

        Map<String, List<String>> qualityStreamUrlsMap = new LinkedHashMap<>();
        List<StreamDTO> streamDTOS = playurlInfoDTO.getPlayurl().getStream();

        for (StreamDTO streamDTO : streamDTOS) {
            for (FormatDTO formatDTO : streamDTO.getFormat()) {
                for (CodecDTO codecDTO : formatDTO.getCodec()) {
                    String key = buildQualityName(streamDTO, formatDTO, codecDTO);
                    List<String> streamUrls = buildStreamUrls(codecDTO);
                    qualityStreamUrlsMap.put(key, streamUrls);
                }
            }
        }

        return qualityStreamUrlsMap;
    }

    private static String buildQualityName(StreamDTO streamDTO, FormatDTO formatDTO, CodecDTO codecDTO) {
        return String.join("_",
                streamDTO.getProtocolName(),
                formatDTO.getFormatName(),
                codecDTO.getCodecName(),
                String.valueOf(codecDTO.getCurrentQn()));
    }

    private static List<String> buildStreamUrls(CodecDTO codecDTO) {
        return StreamEx.of(codecDTO.getUrlInfo())
                       .map(urlInfo -> buildStreamUrl(urlInfo.getHost(), codecDTO.getBaseUrl(), urlInfo.getExtra()))
                       .toList();
    }

    private static String buildStreamUrl(String host, String baseUrl, String extra) {
        return host + baseUrl + extra;
    }
}
