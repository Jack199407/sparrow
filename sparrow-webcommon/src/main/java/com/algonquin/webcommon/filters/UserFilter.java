package com.algonquin.webcommon.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Objects;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String userId = httpServletRequest.getHeader("userId");
        if (!Objects.equals(userId, "Jack")) {
            servletResponse.getWriter().print("User info error!");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
