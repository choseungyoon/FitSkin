package com.fitksin.server.member.controller;

import com.fitksin.server.common.domain.Result;
import com.fitksin.server.common.serice.jwt.JwtService;
import com.fitksin.server.member.domain.Member;
import com.fitksin.server.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public Result signup(@RequestBody Member member){
        Result result = Result.successInstance();
        Member createdMember = this.memberService.signup(member);
        result.setData(createdMember);
        return result;
    }

    @PostMapping("/signIn")
    public Result signIn(String userName, String password, HttpServletResponse response){
        Result result = Result.successInstance();
        Member loginMember = this.memberService.signin(userName,password);
        String token = this.jwtService.create("member",loginMember,"user");
        response.setHeader("Authorization",token);
        result.setData(loginMember);
        return result;
    }

}
