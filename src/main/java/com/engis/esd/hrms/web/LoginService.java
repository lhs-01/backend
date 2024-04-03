package com.engis.esd.hrms.web;

import com.engis.esd.hrms.atnd.AtndService;
import com.engis.esd.hrms.atnd.dto.AtndDTO;
import com.engis.esd.hrms.users.MemberService;
import com.engis.esd.hrms.users.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;

public interface LoginService {

    MemberDTO getMember(String id, String pwd);

    AtndDTO findAtnd(int memberNo);

    void logout(HttpSession session);
}
