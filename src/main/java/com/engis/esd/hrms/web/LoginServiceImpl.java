package com.engis.esd.hrms.web;

import com.engis.esd.hrms.atnd.dto.AtndDTO;
import com.engis.esd.hrms.atnd.repository.AtndRepository;
import com.engis.esd.hrms.users.dto.MemberDTO;
import com.engis.esd.hrms.users.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final MemberRepository memberRepository;
    private final AtndRepository atndRepository;

    private final String DATE_FORMAT = "YYYY-MM-dd";

    private LocalDateTime dateTime;
    private String dateTimeFormat;

    @Override
    public MemberDTO getMember(String id, String pwd) {
        MemberDTO member = memberRepository.getMember(id, pwd);

        if (member == null){
            return null;
        }
        int memberNo = member.getNo();

        AtndDTO atnd = findAtnd(memberNo);

        return member;
    }

    @Override
    public AtndDTO findAtnd(int memberNo) {
        AtndDTO atnd = atndRepository.findAtnd(memberNo);
        if (atnd == null) {
            atndRepository.insertAtnd(memberNo);
        }

        dateTime = LocalDateTime.now();
        dateTimeFormat = dateTime.format(DateTimeFormatter.ofPattern(DATE_FORMAT));

        //오늘 날짜의 출근기록이 있는 경우거나, 출근하고 12시 넘었는데 퇴근을 못한 경우엔 생성 안함
        atndCheckLogic(memberNo, atnd);

        return atndRepository.findAtnd(memberNo);
    }

    private void atndCheckLogic(int userNo, AtndDTO atnd) {

        if(dateTimeFormat.equals(atnd.getToday()) ||
                ((atnd.getStartTime() != null) && (atnd.getEndTime() == null))){

        } else {
            atndRepository.insertAtnd(userNo);
        }
    }

    @Override
    public void logout(HttpSession session) {

    }
}
