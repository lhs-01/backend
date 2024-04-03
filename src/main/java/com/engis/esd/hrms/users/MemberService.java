package com.engis.esd.hrms.users;

import com.engis.esd.hrms.users.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;

public interface MemberService {
    MemberDTO getMember(String id, String pwd);

    int logout(HttpSession session);
}
