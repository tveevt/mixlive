package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CodecDTO {
    @JsonProperty("codec_name")
    private String codecName;
    @JsonProperty("current_qn")
    private Integer currentQn;
    @JsonProperty("accept_qn")
    private List<Integer> acceptQn;
    @JsonProperty("base_url")
    private String baseUrl;
    @JsonProperty("url_info")
    private List<UrlInfoDTO> urlInfo;
    @JsonProperty("hdr_qn")
    private Object hdrQn;
    @JsonProperty("dolby_type")
    private Integer dolbyType;
    @JsonProperty("attr_name")
    private String attrName;
    @JsonProperty("hdr_type")
    private Integer hdrType;
}
