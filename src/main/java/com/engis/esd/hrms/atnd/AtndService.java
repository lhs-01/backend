package com.engis.esd.hrms.atnd;

import com.engis.esd.hrms.atnd.dto.AtndDTO;

public interface AtndService {
    int insertAtnd(int memberNo);

    AtndDTO findAtnd(int memberNo);

    int updateStartTime(int no, String state);

    int updateEndTime(int no, String state);

    int updateState(int no, String state);
}
