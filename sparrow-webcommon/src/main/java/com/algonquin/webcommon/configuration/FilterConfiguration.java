package com.algonquin.webcommon.configuration;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class FilterConfiguration {
    @Value("UTF-8")
    private String encoding;
    @Bean
    public FilterRegistrationBean characterEncodingFilter() {
        FilterRegistrationBean bean = this.createFilter(new CharacterEncodingFilter(), 0, "/*");
        bean.addInitParameter("encoding", this.encoding);
        bean.addInitParameter("forceEncoding", "true");
        return bean;
    }

    public FilterRegistrationBean createFilter(Filter filter, int order, String... urlPatterns) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setOrder(order);
        filterRegistrationBean.addUrlPatterns(urlPatterns);
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistrationBean;
    }
}
