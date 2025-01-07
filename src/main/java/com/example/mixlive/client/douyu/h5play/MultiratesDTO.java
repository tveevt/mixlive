package com.example.mixlive.client.douyu.h5play;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MultiratesDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("rate")
    private Integer rate;
    @JsonProperty("highBit")
    private Integer highBit;
    @JsonProperty("bit")
    private Integer bit;
    @JsonProperty("diamondFan")
    private Integer diamondFan;
}
