package com.algonquin.web.controller;


import com.algonquin.web.dto.RequestInfoRequest;
import com.algonquin.web.dto.RequestInfoResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class WebController {
    @PostMapping("/post/method")
    public String postMethod() {
        return "this is post method";
    }
    @GetMapping("/get/method")
    public String getMethod() {
        return "this is get method";
    }

    @PostMapping("/post/request/info")
    public RequestInfoResponse postHttpRequestInfo(HttpServletRequest request, @RequestBody RequestInfoRequest req) {
        return showHeaderInfo(request);
    }

    @GetMapping("/get/request/info")
    public RequestInfoResponse getHttpRequestInfo(HttpServletRequest request, @RequestBody RequestInfoRequest req) {
        return showHeaderInfo(request);
    }

    private RequestInfoResponse showHeaderInfo(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Iterator<String> stringIterator = headerNames.asIterator();
        Map<String, String> headerMap = new HashMap<>();
        while(stringIterator.hasNext()) {
            String next = stringIterator.next();
            headerMap.put(next, request.getHeader(next));
        }
        return new RequestInfoResponse(request.getMethod(), request.getRequestURL().toString(), headerMap);
    }
}
