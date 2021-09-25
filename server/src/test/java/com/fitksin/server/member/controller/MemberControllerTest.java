package com.fitksin.server.member.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenRequestOnPublicPage_shouldReturn200() throws Exception{
        mvc.perform(
                get("/member/")
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    public void givenRequestOnPrivateAndAdminPageWithoutLogin_shouldReturn401() throws Exception {
        mvc.perform(
                get("/member/private")
        ).andExpect(
                status().isUnauthorized()
        );

        mvc.perform(
                get("/member/admin")
        ).andExpect(
                status().isUnauthorized()
        );
    }

    @Test
    @WithMockUser(value = "fake_user")
    public void givenRequestOnPrivatePageWithCredential_shouldReturn200() throws Exception{
        mvc.perform(
                get("/member/private")
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    @WithMockUser(value = "fake_user")
    public void givenRequestOnAdminPageWithCredential_shouldReturn403() throws Exception{
        mvc.perform(
                get("/member/admin")
        ).andExpect(
                status().isForbidden()
        );
    }

    @Test
    @WithMockUser(value = "fake_user" , roles = "ADMIN")
    public void givenRequestOnAdminPageWithAdminRole_shouldReturn200() throws Exception{
        mvc.perform(
                get("/member/admin")
        ).andExpect(
                status().isOk()
        );
    }
}