package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GQnDescDTO {
    @JsonProperty("qn")
    private Integer qn;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("hdr_desc")
    private String hdrDesc;
    @JsonProperty("attr_desc")
    private Object attrDesc;
    @JsonProperty("hdr_type")
    private Integer hdrType;
}
