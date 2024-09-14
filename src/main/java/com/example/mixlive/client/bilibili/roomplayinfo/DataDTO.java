package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTO {
    @JsonProperty("room_id")
    private Integer roomId;
    @JsonProperty("short_id")
    private Integer shortId;
    @JsonProperty("uid")
    private Long uid;
    @JsonProperty("is_hidden")
    private Boolean isHidden;
    @JsonProperty("is_locked")
    private Boolean isLocked;
    @JsonProperty("is_portrait")
    private Boolean isPortrait;
    @JsonProperty("live_status")
    private Integer liveStatus;
    @JsonProperty("hidden_till")
    private Integer hiddenTill;
    @JsonProperty("lock_till")
    private Integer lockTill;
    @JsonProperty("encrypted")
    private Boolean encrypted;
    @JsonProperty("pwd_verified")
    private Boolean pwdVerified;
    @JsonProperty("live_time")
    private Long liveTime;
    @JsonProperty("room_shield")
    private Integer roomShield;
    @JsonProperty("all_special_types")
    private List<Integer> allSpecialTypes;
    @JsonProperty("playurl_info")
    private PlayurlInfoDTO playurlInfo;
    @JsonProperty("official_type")
    private Integer officialType;
    @JsonProperty("official_room_id")
    private Integer officialRoomId;
    @JsonProperty("risk_with_delay")
    private Integer riskWithDelay;
}
