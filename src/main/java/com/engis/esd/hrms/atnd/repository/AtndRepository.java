package com.engis.esd.hrms.atnd.repository;

import com.engis.esd.hrms.atnd.dto.AtndDTO;

public interface AtndRepository {

    int insertAtnd(int memberNo);

    AtndDTO findAtnd(int memberNo);

    int updateStartTiem(int no, String state);

    int updateEndTime(int no, String state);

    int updateState(int no, String state);
}
