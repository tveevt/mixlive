package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class StreamDTO {
    @JsonProperty("protocol_name")
    private String protocolName;
    @JsonProperty("format")
    private List<FormatDTO> format;
}
