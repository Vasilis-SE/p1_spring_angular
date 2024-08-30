package com.myback.shared.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@SuppressWarnings("null")
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private PaginationSortingInterceptor paginationSortingInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(paginationSortingInterceptor)
                .addPathPatterns("/api/v1/continents")
                .addPathPatterns("/api/v1/continents/tree")
                .addPathPatterns("/api/v1/continents/tree/min");
    }
}