package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CostTimeDTO {
    @JsonProperty("total")
    private String total;
    @JsonProperty("fetch_lexicon")
    private String fetchLexicon;
    @JsonProperty("params_check")
    private String paramsCheck;
    @JsonProperty("is_risk_query")
    private String isRiskQuery;
    @JsonProperty("illegal_handler")
    private String illegalHandler;
    @JsonProperty("main_handler")
    private String mainHandler;
    @JsonProperty("as_doc_request")
    private String asDocRequest;
    @JsonProperty("deserialize_response")
    private String deserializeResponse;
    @JsonProperty("as_request_format")
    private String asRequestFormat;
    @JsonProperty("as_request")
    private String asRequest;
    @JsonProperty("as_response_format")
    private String asResponseFormat;
}
