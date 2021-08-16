package com.fitksin.server.member.service;

import com.fitksin.server.member.domain.Member;

public interface MemberService {

    Member signin(String username, String password);

    Member signup(Member member);

    boolean isExist(String userName);

    void validate(String userName);

}
