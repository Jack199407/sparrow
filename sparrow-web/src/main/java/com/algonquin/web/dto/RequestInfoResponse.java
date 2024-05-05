package com.algonquin.web.dto;

import lombok.Data;

import java.util.Map;

@Data
public class RequestInfoResponse {
    String method;
    String requestURL;
    Map<String, String> headInfos;

    public RequestInfoResponse(String method, String requestURL, Map<String, String> headInfos) {
        this.method = method;
        this.requestURL = requestURL;
        this.headInfos = headInfos;
    }
}
