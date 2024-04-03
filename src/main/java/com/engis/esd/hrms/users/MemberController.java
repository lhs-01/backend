package com.engis.esd.hrms.users;

import com.engis.esd.hrms.users.dto.MemberDTO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/user")
@Slf4j
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session, ModelAndView mv) {
        memberService.logout(session);
        mv.setViewName("/user/login");
        mv.addObject("message", "logout");
        return mv;
    }

}
