package com.example.mixlive.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomInfo {
    private Integer id;
    private String title;
    private String coverUrl;
    // private String username;
    private String categoryName;
    private String hot;
}
