package com.example.mixlive.client.douyu.h5play;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTO {
    @JsonProperty("room_id")
    private Integer roomId;
    @JsonProperty("is_mixed")
    private Boolean isMixed;
    @JsonProperty("mixed_live")
    private String mixedLive;
    @JsonProperty("mixed_url")
    private String mixedUrl;
    @JsonProperty("rtmp_cdn")
    private String rtmpCdn;
    @JsonProperty("rtmp_url")
    private String rtmpUrl;
    @JsonProperty("rtmp_live")
    private String rtmpLive;
    @JsonProperty("client_ip")
    private String clientIp;
    @JsonProperty("inNA")
    private Integer inNA;
    @JsonProperty("rateSwitch")
    private Integer rateSwitch;
    @JsonProperty("rate")
    private Integer rate;
    @JsonProperty("cdnsWithName")
    private List<CdnsWithNameDTO> cdnsWithName;
    @JsonProperty("multirates")
    private List<MultiratesDTO> multirates;
    @JsonProperty("isPassPlayer")
    private Integer isPassPlayer;
    @JsonProperty("eticket")
    private Object eticket;
    @JsonProperty("online")
    private Integer online;
    @JsonProperty("mixedCDN")
    private String mixedCDN;
    @JsonProperty("p2p")
    private Integer p2p;
    @JsonProperty("streamStatus")
    private Integer streamStatus;
    @JsonProperty("smt")
    private Integer smt;
    @JsonProperty("p2pMeta")
    private Object p2pMeta;
    @JsonProperty("p2pCid")
    private Integer p2pCid;
    @JsonProperty("p2pCids")
    private String p2pCids;
    @JsonProperty("player_1")
    private String player1;
    @JsonProperty("h265_p2p")
    private Integer h265P2p;
    @JsonProperty("h265_p2p_cid")
    private Integer h265P2pCid;
    @JsonProperty("h265_p2p_cids")
    private String h265P2pCids;
    @JsonProperty("acdn")
    private String acdn;
    @JsonProperty("av1_url")
    private String av1Url;
    @JsonProperty("rtc_stream_url")
    private String rtcStreamUrl;
    @JsonProperty("rtc_stream_config")
    private String rtcStreamConfig;
    @JsonProperty("pictureQualitySwitch")
    private Integer pictureQualitySwitch;
    @JsonProperty("show_id")
    private String showId;
}
