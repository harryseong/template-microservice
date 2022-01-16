package com.harryseong.templatemicroservice.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * Excludes preflight requests from authorization in Spring Security configuration by
         * adding Spring-provided "CorsFilter" to the application context.
         * This allows application to bypass authorization checks for OPTIONS requests.
         * */
        http.cors();
    }
}
