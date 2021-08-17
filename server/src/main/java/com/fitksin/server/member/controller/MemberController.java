package com.fitksin.server.member.controller;

import com.fitksin.server.common.domain.Result;
import com.fitksin.server.common.serice.jwt.JwtService;
import com.fitksin.server.member.domain.Member;
import com.fitksin.server.member.domain.testDto;
import com.fitksin.server.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/test")
    public boolean test(@RequestBody testDto tt){
        log.info(tt.toString());
        return false;
    }

    @PostMapping(value = "/signup")
    public Result signup(){
        log.info("signUp");
        Result result = Result.successInstance();
        //Member createdMember = this.memberService.signup(member);
        //result.setData(createdMember);
        return result;
    }

    @PostMapping("/signIn")
    public boolean signIn(String userName, String password, HttpServletResponse response){
        log.info("signIn");
        Result result = Result.successInstance();
        Member loginMember = this.memberService.signin(userName,password);
        String token = this.jwtService.create("member",loginMember,"user");
        response.setHeader("Authorization",token);
        result.setData(loginMember);
        return true;
    }



}
