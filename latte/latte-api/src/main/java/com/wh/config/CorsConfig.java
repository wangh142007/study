package com.wh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @program: latte
 * @description:
 * @author: wh
 * @create: 2020-01-20 12:09
 */
@Configuration
public class CorsConfig {

    public CorsConfig() {
    }

    @Bean
    public CorsFilter corsFilter() {
        //1.设置cors配置信息
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8080");
        configuration.addAllowedOrigin("*");

        //设置是否发送cookie信息
        configuration.setAllowCredentials(true);

        //设置允许请求的方式
        configuration.addAllowedMethod("*");
        //设置允许请求的header
        configuration.addAllowedHeader("*");

        //2.为url添加映射路径
        UrlBasedCorsConfigurationSource corsCource = new UrlBasedCorsConfigurationSource();
        corsCource.registerCorsConfiguration("/**",configuration);

        //返回重新定义好的CorsFilter
        return new CorsFilter(corsCource);
    }
}
