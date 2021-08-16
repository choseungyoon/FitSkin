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

    @Column(name = "username")
    private String userName;

    @Column(name = "password_hashed")
    @Basic(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordHashed;

    private String email;

    private boolean admin;

    @Column(name = "invite_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inviteDt;

    @Column(name = "last_login_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDt;

    @Column(name = "inviter_user_id")
    @Nullable
    private String inviterUserId;

    public Member(){}

    public Member(String userName, String passwordHashed, String email, boolean admin, Date inviteDt, Date lastLoginDt, String inviterUserId) {
        this.userName = userName;
        this.passwordHashed = passwordHashed;
        this.email = email;
        this.admin = admin;
        this.inviteDt = inviteDt;
        this.lastLoginDt = lastLoginDt;
        this.inviterUserId = inviterUserId;
    }

    public String getInviteDate(){

        if(inviteDt == null){
            return null;
        }
        else{
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd GG:MM").format(inviteDt);
            return formattedDate;
        }
    }

    public String getLastLoginDate(){
        if(lastLoginDt == null){
            return null;
        }
        else{
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd GG:MM").format(lastLoginDt);
            return formattedDate;
        }
    }

}
