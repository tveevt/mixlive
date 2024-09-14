package com.example.mixlive.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomWithUserInfo {

    private RoomInfo roomInfo;

    private UserInfo userInfo;

}
