package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LinkDTO {
    @JsonProperty("playlistUrl")
    private String playlistUrl;
    @JsonProperty("followUrl")
    private String followUrl;
    @JsonProperty("matchUrl")
    private String matchUrl;
    @JsonProperty("cloudGameUrl")
    private String cloudGameUrl;
    @JsonProperty("rankUrl")
    private String rankUrl;
    @JsonProperty("webGameUrl")
    private String webGameUrl;
}
