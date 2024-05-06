package com.algonquin.webcommon.configuration;

import com.algonquin.webcommon.filters.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<UserFilter> userFilter() {
        FilterRegistrationBean<UserFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new UserFilter());
        bean.setOrder(0);
        bean.addUrlPatterns("/*");
        return bean;
    }
}
