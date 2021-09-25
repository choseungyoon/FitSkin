package com.fitksin.server.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/member/admin/**").hasRole("ADMIN")
                .antMatchers("/member/private/**").hasRole("USER")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
