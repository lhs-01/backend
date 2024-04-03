package com.engis.esd.hrms.atnd;

import com.engis.esd.hrms.atnd.dto.AtndDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/timeCheck")
@Slf4j
public class AtndController {

    private final AtndService atndService;

    @Autowired
    public AtndController(AtndService atndService){
        this.atndService = atndService;
    }


    //페이지 이동 시 출퇴근 시간 조회
    @GetMapping( "/{no}")
    public AtndDTO findUserTime(@PathVariable("no") int no){
        log.info("path no = {}", no);
        AtndDTO atndDTO = atndService.findAtnd(no);
        return atndDTO;
    }


    //출퇴근 버튼 클릭
    @PostMapping("/{no}")
    public String setWorkTime(@PathVariable("no") int no) {
        log.info("path no =  {}", no);
        String status = "";

        AtndDTO atnd = atndService.findAtnd(no);

        int atndNo = atnd.getNo();

        /**
         * state
         * w - 출근
         * l - 퇴근
         * o - 외근
         */

        // 출근 로직
        if(atnd.getStartTime() == null){
            status = "w";
            atndService.updateStartTime(atndNo, status);
            status = "출근하였습니다.";
            return status;
        }

        if(atnd.getEndTime() == null){
            status = "l";
            atndService.updateEndTime(atndNo, status);
            status = "퇴근하였습니다.";
            return status;
        }

        return status;
    }

}
