package com.example.mixlive.client.douyu.streamurl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTO {
    @JsonProperty("settings")
    private List<SettingsDTO> settings;
    @JsonProperty("url")
    private String url;
    @JsonProperty("rate")
    private Integer rate;
    @JsonProperty("pass")
    private Integer pass;
    @JsonProperty("share_offset_time")
    private Integer shareOffsetTime;
}
