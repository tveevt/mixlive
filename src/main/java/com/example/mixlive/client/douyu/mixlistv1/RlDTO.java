package com.example.mixlive.client.douyu.mixlistv1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RlDTO {
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("rid")
    private Integer rid;
    @JsonProperty("rn")
    private String rn;
    @JsonProperty("uid")
    private Long uid;
    @JsonProperty("nn")
    private String nn;
    @JsonProperty("cid1")
    private Integer cid1;
    @JsonProperty("cid2")
    private Integer cid2;
    @JsonProperty("cid2_display")
    private Integer cid2Display;
    @JsonProperty("cid3")
    private Integer cid3;
    @JsonProperty("av")
    private String av;
    @JsonProperty("ol")
    private Integer ol;
    @JsonProperty("c2url")
    private String c2url;
    @JsonProperty("c2url_display")
    private String c2urlDisplay;
    @JsonProperty("c2name")
    private String c2name;
    @JsonProperty("c2name_display")
    private String c2nameDisplay;
    @JsonProperty("rs16")
    private String rs16;
    @JsonProperty("rs16_cover_id")
    private Integer rs16CoverId;
    @JsonProperty("rs16_avif")
    private String rs16Avif;
    @JsonProperty("rs_ext")
    private List<RsExtDTO> rsExt;
    @JsonProperty("chanid")
    private Integer chanid;
    @JsonProperty("icv3")
    private Object icv3;
    @JsonProperty("authInfo")
    private AuthInfoDTO authInfo;
    @JsonProperty("roomLabel")
    private List<String> roomLabel;
    @JsonProperty("dot")
    private Integer dot;
    @JsonProperty("edot")
    private Integer edot;
    @JsonProperty("rt")
    private Integer rt;
    @JsonProperty("rst")
    private Integer rst;
    @JsonProperty("url")
    private String url;
    @JsonProperty("dotV1")
    private DotV1DTO dotV1;
    @JsonProperty("isBigRec")
    private Integer isBigRec;
}
