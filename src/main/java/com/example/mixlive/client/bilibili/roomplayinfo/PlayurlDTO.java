package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PlayurlDTO {
    @JsonProperty("cid")
    private Integer cid;
    @JsonProperty("g_qn_desc")
    private List<GQnDescDTO> gQnDesc;
    @JsonProperty("stream")
    private List<StreamDTO> stream;
    @JsonProperty("p2p_data")
    private P2pDataDTO p2pData;
    @JsonProperty("dolby_qn")
    private Object dolbyQn;
}
