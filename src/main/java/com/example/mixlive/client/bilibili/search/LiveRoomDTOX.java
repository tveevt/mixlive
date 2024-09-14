package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class LiveRoomDTOX {
    @JsonProperty("area")
    private Integer area;
    @JsonProperty("attentions")
    private Integer attentions;
    @JsonProperty("cate_name")
    private String cateName;
    @JsonProperty("cover")
    private String cover;
    @JsonProperty("hit_columns")
    private List<String> hitColumns;
    @JsonProperty("is_live_room_inline")
    private Integer isLiveRoomInline;
    @JsonProperty("live_status")
    private Integer liveStatus;
    @JsonProperty("live_time")
    private String liveTime;
    @JsonProperty("online")
    private Integer online;
    @JsonProperty("rank_index")
    private Integer rankIndex;
    @JsonProperty("rank_offset")
    private Integer rankOffset;
    @JsonProperty("rank_score")
    private Integer rankScore;
    @JsonProperty("roomid")
    private Integer roomid;
    @JsonProperty("short_id")
    private Integer shortId;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uface")
    private String uface;
    @JsonProperty("uid")
    private Long uid;
    @JsonProperty("uname")
    private String uname;
    @JsonProperty("user_cover")
    private String userCover;
    @JsonProperty("watched_show")
    private WatchedShowDTO watchedShow;
}
