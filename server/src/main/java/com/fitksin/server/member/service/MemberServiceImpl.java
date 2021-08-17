package com.fitksin.server.member.service;

import com.fitksin.server.common.utils.EntityUtils;
import com.fitksin.server.member.domain.Member;
import com.fitksin.server.member.repository.MemberRepository;
import com.fitksin.server.member.service.MemberService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

    private static final String DEFAULT_NICKNAME = "번째러버";
    private static final String PROFILE_DEFAULT_PATH = "/profile/0/profile_default.jpg";
    private static final String SIGNIN_EXCEPTION_MSG = "로그인정보가 일치하지 않습니다.";
    private static final String USER_EXIST_EXCEPTION_MSG = "이미 계정이 존재합니다.";
    private static final String NICKNAME_EXIST_EXCEPTION_MSG = "이미 닉네임이 존재합니다.";


    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public  Member signup(Member member){
        String userName = member.getUserName();
        this.validate(userName);
        this.setupForSave(member);
        Member createdMember = this.memberRepository.save(member);
        return createdMember;
    }

    private void setupForSave(Member member){
        String password = member.getPasswordHashed();
        //member.setPasswordHashed(encodedPassword);
        EntityUtils.initializeInviteAndLastLoginDate(member);
    }

    @Override
    public Member signin(String username, String password){
        Member member = this.memberRepository.findByUserName(username);
        Objects.requireNonNull(member, SIGNIN_EXCEPTION_MSG);

        if(!this.isAccordPassword(member,password)){
            throw new IllegalStateException(SIGNIN_EXCEPTION_MSG);
        }
        return member;
    }

    @Override
    public boolean isExist(String userName){
        boolean isExist = false;
        Member member = this.memberRepository.findByUserName(userName);
        if(member != null) {
            isExist = true;
        }
        return isExist;
    }

    @Override
    public void validate(String userName){
        if(this.isExist(userName)){
            throw new IllegalStateException(USER_EXIST_EXCEPTION_MSG);
        }
    }

    private boolean isAccordPassword(Member member, String password){
        String encodedPassword = member.getPasswordHashed();
        //return BCrypt.checkpw(password,encodedPassword);
        return true;
    }
}
