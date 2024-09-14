package com.example.mixlive.client.douyu.streamurl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SettingsDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("rate")
    private Integer rate;
    @JsonProperty("high_bit")
    private Integer highBit;
}
