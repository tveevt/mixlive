package com.example.mixlive.client.bilibili.playurl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QualityDescriptionDTO {
    @JsonProperty("qn")
    private Integer qn;
    @JsonProperty("desc")
    private String desc;
}
