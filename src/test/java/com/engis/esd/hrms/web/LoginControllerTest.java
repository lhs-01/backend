package com.engis.esd.hrms.web;

import com.engis.esd.hrms.atnd.AtndMapper;
import com.engis.esd.hrms.atnd.AtndService;
import com.engis.esd.hrms.atnd.repository.AtndRepository;
import com.engis.esd.hrms.users.MemberMapper;
import com.engis.esd.hrms.users.MemberService;
import com.engis.esd.hrms.users.dto.MemberDTO;
import com.engis.esd.hrms.users.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class LoginControllerTest {
    @Autowired
    private LoginService loginService;

    @Test
    void loginTest() {
        String id = "jsg";
        String pwd = "1111";

        MemberDTO user = loginService.getMember(id, pwd);
        assertThat(user).isNotNull();

    }

}