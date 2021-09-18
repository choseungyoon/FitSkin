package com.fitksin.server.member.repository;

import com.fitksin.server.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {

    Member findByEmail(String email);
}
