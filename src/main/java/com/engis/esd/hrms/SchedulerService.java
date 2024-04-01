package com.engis.esd.hrms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SchedulerService {

    @Autowired
    private final SchedulerMapper schedulerMapper;

    public SchedulerService(SchedulerMapper schedulerMapper) {
        this.schedulerMapper = schedulerMapper;
    }

    //월요일-일요일 am5시 실행
    @Scheduled(cron = "0 0 5 * * 1-5", zone="Asia/Seoul")
    public void autoWorkEnd() {
        log.info("---------- autoWorkEnd() ----------");
        schedulerMapper.autoWorkEnd();
    }

}
