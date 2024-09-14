package com.example.mixlive.client.douyu.catetab;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CateTab {

    @JsonProperty("cateTabIcon")
    private String cateTabIcon;
    @JsonProperty("cateTabIconSvg")
    private String cateTabIconSvg;
    @JsonProperty("checkedCateTabIconSvg")
    private String checkedCateTabIconSvg;
    @JsonProperty("cid")
    private Integer cid;
    @JsonProperty("cid1")
    private Integer cid1;
    @JsonProperty("cid2")
    private Integer cid2;
    @JsonProperty("cid3")
    private Integer cid3;
    @JsonProperty("isRkl")
    private Integer isRkl;
    @JsonProperty("is_audio")
    private Integer isAudio;
    @JsonProperty("link")
    private String link;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pagePath")
    private String pagePath;
    @JsonProperty("pgcnt")
    private Integer pgcnt;
    @JsonProperty("recommendRule")
    private Integer recommendRule;
    @JsonProperty("roomRule")
    private Integer roomRule;
    @JsonProperty("sn")
    private String sn;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("unCheckedCateTabIconSvg")
    private String unCheckedCateTabIconSvg;

}
