package com.example.spring_boot_na_pratica.configs;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
@Order(1)
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureApiVersioning(ApiVersionConfigurer config) {
        config
            .useRequestHeader("X-API-VERSION")
            .setDefaultVersion("v1");
    }
}