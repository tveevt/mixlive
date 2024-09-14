package com.example.mixlive.client.bilibili.livestreamlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ListDTO {
    @JsonProperty("roomid")
    private Integer roomid;
    @JsonProperty("uid")
    private Long uid;
    @JsonProperty("title")
    private String title;
    @JsonProperty("uname")
    private String uname;
    @JsonProperty("online")
    private Integer online;
    @JsonProperty("user_cover")
    private String userCover;
    @JsonProperty("user_cover_flag")
    private Integer userCoverFlag;
    @JsonProperty("system_cover")
    private String systemCover;
    @JsonProperty("cover")
    private String cover;
    @JsonProperty("show_cover")
    private String showCover;
    @JsonProperty("link")
    private String link;
    @JsonProperty("face")
    private String face;
    @JsonProperty("parent_id")
    private Integer parentId;
    @JsonProperty("parent_name")
    private String parentName;
    @JsonProperty("area_id")
    private Integer areaId;
    @JsonProperty("area_name")
    private String areaName;
    @JsonProperty("area_v2_parent_id")
    private Integer areaV2ParentId;
    @JsonProperty("area_v2_parent_name")
    private String areaV2ParentName;
    @JsonProperty("area_v2_id")
    private Integer areaV2Id;
    @JsonProperty("area_v2_name")
    private String areaV2Name;
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("group_id")
    private Integer groupId;
    @JsonProperty("show_callback")
    private String showCallback;
    @JsonProperty("click_callback")
    private String clickCallback;
    @JsonProperty("web_pendent")
    private String webPendent;
    @JsonProperty("pk_id")
    private Integer pkId;
    @JsonProperty("pendant_info")
    private PendantInfoDTO pendantInfo;
    @JsonProperty("verify")
    private VerifyDTO verify;
    @JsonProperty("head_box")
    private Object headBox;
    @JsonProperty("head_box_type")
    private Integer headBoxType;
    @JsonProperty("is_auto_play")
    private Integer isAutoPlay;
    @JsonProperty("flag")
    private Integer flag;
    @JsonProperty("watched_show")
    private WatchedShowDTO watchedShow;
    @JsonProperty("is_nft")
    private Integer isNft;
    @JsonProperty("nft_dmark")
    private String nftDmark;
    @JsonProperty("play_together_goods")
    private Object playTogetherGoods;
    @JsonProperty("watermark")
    private String watermark;
}
