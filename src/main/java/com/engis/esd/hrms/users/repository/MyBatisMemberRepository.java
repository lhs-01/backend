package com.engis.esd.hrms.users.repository;

import com.engis.esd.hrms.users.MemberMapper;
import com.engis.esd.hrms.users.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MyBatisMemberRepository implements MemberRepository {
    private final MemberMapper memberMapper;
    @Override
    public MemberDTO getMember(String id, String pwd) {
        return memberMapper.getMember(id,pwd);
    }
}
