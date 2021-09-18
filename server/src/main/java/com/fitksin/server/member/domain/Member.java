package com.fitksin.server.member.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    @Basic(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;

    private boolean admin;

    public Member(){}

    public Member(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.admin = true;
    }


}
