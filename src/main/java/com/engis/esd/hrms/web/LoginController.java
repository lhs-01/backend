package com.engis.esd.hrms.web;

import com.engis.esd.hrms.atnd.dto.AtndDTO;
import com.engis.esd.hrms.atnd.repository.AtndRepository;
import com.engis.esd.hrms.users.dto.MemberDTO;
import com.engis.esd.hrms.users.repository.MemberRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public MemberDTO login(@RequestBody MemberDTO memberDTO, HttpSession session, HttpServletResponse response) {
        String loginId = memberDTO.getId();
        String loginPwd = memberDTO.getPwd();

        log.info("loginId : {}", loginId);
        log.info("loginPwd : {}", loginPwd);

        MemberDTO member = loginService.getMember(loginId, loginPwd);

        if(member != null) {
            session.setAttribute("userId", member.getId());
            session.setAttribute("userNo",member.getNo());
        }else{
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return null;
        }

        return member;
    }

}
