package com.domeastudio.mappingo.servers.microservice.inventory.config;

import com.domeastudio.mappingo.servers.microservice.inventory.filter.JWTAuthenticationFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties("spring.white-list")
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    private String[] serviceFilter;

//    @Bean
//    public FilterRegistrationBean basicFilterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        JWTAuthenticationFilter httpBasicFilter = new JWTAuthenticationFilter();
//        registrationBean.setFilter(httpBasicFilter);
//        List<String> urlPatterns = new ArrayList<>();
//        for(String str : serviceFilter){
//            urlPatterns.add(str);
//        }
//        registrationBean.setUrlPatterns(urlPatterns);
//        return registrationBean;
//    }
    //跨域配置代码式
//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*"); // 1 设置访问源地址
//        corsConfiguration.addAllowedHeader("*"); // 2 设置访问源请求头
//        corsConfiguration.addAllowedMethod("*"); // 3 设置访问源请求方法
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
//        return new CorsFilter(source);
//    }

    @Bean
    public FilterRegistrationBean jwtFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JWTAuthenticationFilter httpBearerFilter = new JWTAuthenticationFilter();
        registrationBean.setFilter(httpBearerFilter);
        List<String> urlPatterns = new ArrayList<>();
        for (String str : serviceFilter) {
            urlPatterns.add(str);
        }
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

    public String[] getServiceFilter() {
        return serviceFilter;
    }

    public void setServiceFilter(String[] serviceFilter) {
        this.serviceFilter = serviceFilter;
    }
}
