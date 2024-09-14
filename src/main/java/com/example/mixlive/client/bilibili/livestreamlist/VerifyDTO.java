package com.example.mixlive.client.bilibili.livestreamlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VerifyDTO {
    @JsonProperty("role")
    private Integer role;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("type")
    private Integer type;
}
