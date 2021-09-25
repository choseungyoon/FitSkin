package com.fitksin.server.member.controller;

import com.fitksin.server.common.domain.Result;
import com.fitksin.server.member.domain.Member;
import com.fitksin.server.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    //private MemberService memberService;


    @PostMapping(value = "/signup")
    public Result signup(@RequestBody Member member){
        log.info("signUp");
        Result result = Result.successInstance();
        //Member createdMember = this.memberService.signup(member);
        //result.setData(createdMember);
        return result;
    }

    @PostMapping(value = "/login")
    public boolean signIn(@RequestBody Member member){
        log.info("signIn");
        log.info("email : " + member.getEmail());
        log.info(("password : " + member.getPassword()));
/*        Result result = Result.successInstance();
        Member loginMember = this.memberService.signin(userName,password);
        String token = this.jwtService.create("member",loginMember,"user");
        response.setHeader("Authorization",token);
        result.setData(loginMember);*/
        return true;
    }

    @RequestMapping(value = "/")
    public String handlePublic(){
        return "Public page";
    }

    @RequestMapping(value = "/private")
    public String handlePrivate(){
        return "private page";
    }

    @RequestMapping(value = "/admin")
    public String handleAdmin(){
        return "Admin page";
    }


}
