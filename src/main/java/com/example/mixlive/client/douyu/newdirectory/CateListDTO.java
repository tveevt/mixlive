package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CateListDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("stn1")
    private String stn1;
    @JsonProperty("cn1")
    private String cn1;
    @JsonProperty("relId")
    private Integer relId;
    @JsonProperty("list")
    private List<ListDTO> list;
}
