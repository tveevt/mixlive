package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class FormatDTO {
    @JsonProperty("format_name")
    private String formatName;
    @JsonProperty("codec")
    private List<CodecDTO> codec;
    @JsonProperty("master_url")
    private String masterUrl;
}
