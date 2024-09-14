package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ResultDTO {
    @JsonProperty("live_room")
    private List<LiveRoomDTOX> liveRoom;
    @JsonProperty("live_user")
    private List<LiveUserDTOX> liveUser;
}
