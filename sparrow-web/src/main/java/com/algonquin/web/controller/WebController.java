package com.algonquin.web.controller;


import com.algonquin.domain.service.BundleService;
import com.algonquin.web.dto.RequestInfoRequest;
import com.algonquin.web.dto.RequestInfoResponse;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Log4j2
public class WebController {

    @Resource
    private BundleService bundleService;

    @PostMapping("/post/method")
    public String postMethod() {
        return "this is post method";
    }
    @GetMapping("/get/method")
    public String getMethod() {
        return "this is get method";
    }

    @PostMapping("/getUserName")
    public String getLocale() {
        return bundleService.getName();
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
