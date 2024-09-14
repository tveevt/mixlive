package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PageinfoDTO {
    @JsonProperty("live_user")
    private LiveUserDTO liveUser;
    @JsonProperty("live_room")
    private LiveRoomDTO liveRoom;
}
