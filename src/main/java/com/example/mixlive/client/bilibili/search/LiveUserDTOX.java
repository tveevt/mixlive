package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class LiveUserDTOX {
    @JsonProperty("area")
    private Integer area;
    @JsonProperty("area_v2_id")
    private Integer areaV2Id;
    @JsonProperty("attentions")
    private Integer attentions;
    @JsonProperty("cate_name")
    private String cateName;
    @JsonProperty("hit_columns")
    private List<String> hitColumns;
    @JsonProperty("is_live")
    private Boolean isLive;
    @JsonProperty("live_status")
    private Integer liveStatus;
    @JsonProperty("live_time")
    private String liveTime;
    @JsonProperty("rank_index")
    private Integer rankIndex;
    @JsonProperty("rank_offset")
    private Integer rankOffset;
    @JsonProperty("rank_score")
    private Integer rankScore;
    @JsonProperty("roomid")
    private Integer roomid;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uface")
    private String uface;
    @JsonProperty("uid")
    private Integer uid;
    @JsonProperty("uname")
    private String uname;
}
