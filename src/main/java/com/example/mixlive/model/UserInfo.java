package com.example.mixlive.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {

    private Long id;
    private String username;
    private String userAvatarUrl;
    // private String roomUrl;

}
