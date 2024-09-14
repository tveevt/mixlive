package com.example.mixlive.client.douyu.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RelateShowDTO {
    @JsonProperty("algorithm")
    private AlgorithmDTO algorithm;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("cateName")
    private String cateName;
    @JsonProperty("cid")
    private Integer cid;
    @JsonProperty("coverId")
    private Integer coverId;
    @JsonProperty("desList")
    private List<?> desList;
    @JsonProperty("desType")
    private Integer desType;
    @JsonProperty("desVersion")
    private String desVersion;
    @JsonProperty("description")
    private String description;
    @JsonProperty("descriptionV2")
    private String descriptionV2;
    @JsonProperty("flag")
    private String flag;
    @JsonProperty("followStatus")
    private Integer followStatus;
    @JsonProperty("hot")
    private String hot;
    @JsonProperty("isLive")
    private Integer isLive;
    @JsonProperty("isVertical")
    private Integer isVertical;
    @JsonProperty("nickName")
    private String nickName;
    @JsonProperty("rid")
    private Integer rid;
    @JsonProperty("roomName")
    private String roomName;
    @JsonProperty("roomSrc")
    private String roomSrc;
    @JsonProperty("roomType")
    private Integer roomType;
    @JsonProperty("tid")
    private Integer tid;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("videoSchemeUrl")
    private String videoSchemeUrl;
}
