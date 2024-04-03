package com.engis.esd.hrms.users;

import com.engis.esd.hrms.users.dto.MemberDTO;
import com.engis.esd.hrms.users.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public MemberDTO getMember(String id, String pwd) {
        return memberRepository.getMember(id, pwd);
    }

    @Override
    public int logout(HttpSession session) {
        return 0;
    }
}
