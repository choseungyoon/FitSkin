package com.fitksin.server.security;

import com.fitksin.server.common.error.UnauthorizedException;
import com.fitksin.server.common.serice.jwt.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "Authorization";

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        log.info("preHandle!");

        final String token = request.getHeader(HEADER_AUTH);

        if(token != null && jwtService.isUsable(token)){
            return true;
        }else{
            throw new UnauthorizedException();
        }
    }

}
