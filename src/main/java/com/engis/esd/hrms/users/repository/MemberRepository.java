package com.engis.esd.hrms.users.repository;

import com.engis.esd.hrms.users.dto.MemberDTO;

public interface MemberRepository {
    MemberDTO getMember(String id, String pwd);

}
