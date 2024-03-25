package com.engis.esd.hrms;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchedulerMapper {

    void autoWorkEnd();
}
