package com.example.mixlive.client.douyu.mixlistv1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthInfoDTO {
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("descV2")
    private String descV2;
}
