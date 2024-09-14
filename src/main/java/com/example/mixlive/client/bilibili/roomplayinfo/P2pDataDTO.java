package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class P2pDataDTO {
    @JsonProperty("p2p")
    private Boolean p2p;
    @JsonProperty("p2p_type")
    private Integer p2pType;
    @JsonProperty("m_p2p")
    private Boolean mP2p;
    @JsonProperty("m_servers")
    private Object mServers;
}
