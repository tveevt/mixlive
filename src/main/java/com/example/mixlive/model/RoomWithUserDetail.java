package com.example.mixlive.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomWithUserDetail {

    private RoomDetail roomDetail;

    private UserDetail userDetail;

}
