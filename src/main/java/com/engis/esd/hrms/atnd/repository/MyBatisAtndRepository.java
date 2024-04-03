package com.engis.esd.hrms.atnd.repository;

import com.engis.esd.hrms.atnd.AtndMapper;
import com.engis.esd.hrms.atnd.dto.AtndDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisAtndRepository implements AtndRepository{

    private final AtndMapper atndMapper;
    @Override
    public int insertAtnd(int memberNo) {
        return atndMapper.insertAtnd(memberNo);
    }

    @Override
    public AtndDTO findAtnd(int memberNo) {
        return atndMapper.findAtnd(memberNo);
    }

    @Override
    public int updateStartTiem(int no, String state) {
        return atndMapper.updateStartTime(no, state);
    }

    @Override
    public int updateEndTime(int no, String state) {
        return atndMapper.updateEndTime(no, state);
    }

    @Override
    public int updateState(int no, String state) {
        return atndMapper.updateState(no, state);
    }
}
