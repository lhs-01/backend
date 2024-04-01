package com.engis.esd.hrms.cmt;

import com.engis.esd.hrms.cmt.dto.CmtDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "http://192.168.0.30")
@RestController
@RequestMapping("/timeCheck")
public class CmtController {

    private final CmtService cmtService;

    @Autowired
    public CmtController(CmtService cmtService){
        this.cmtService = cmtService;
    }


    //페이지 이동 시 출퇴근 시간 조회
    @GetMapping( "/findUserTime")
    public CmtDTO findUserTime(String no){
        int userNo = Integer.parseInt(no);
        CmtDTO cmtDTO = cmtService.findUserTime(userNo);
        System.out.println(cmtDTO);

        String lastAttTime = cmtDTO.getAttTime().substring(0,10);

        LocalDateTime now = LocalDateTime.now();
        String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        if(!(lastAttTime.equals(formatNow))) {
            cmtDTO.setAttTime(null);
            cmtDTO.setLvWrkTime(null);
        }

        return cmtDTO;
    }


    //출퇴근 버튼 클릭
    @PostMapping("/setWorkTime")
    public String setWorkTime(@RequestBody CmtDTO cmtDTO) {
        String status = "";

        int no = cmtDTO.getNo();
        CmtDTO cmt = cmtService.findUserTime(no);

        String lastAttTime = cmt.getAttTime().substring(0,10);
        String lastLvTime = cmt.getLvWrkTime();

        LocalDateTime now = LocalDateTime.now();
        String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        if(lastAttTime.equals(formatNow)) {
            System.out.println("getlvWrktime = " + cmt.getLvWrkTime());
            if(cmt.getLvWrkTime()==null) {
                status = "퇴근완료";
                cmtService.setWorkEnd(cmt);
            } else {
                status = "이미 오늘의 출퇴근이 등록되었습니다.";
            }
        } else {
            status = "출근완료";
            cmtService.setWorkStart(cmt);
         }

        return status;
    }

}
