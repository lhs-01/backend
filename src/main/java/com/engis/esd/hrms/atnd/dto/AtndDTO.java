package com.engis.esd.hrms.atnd.dto;

import lombok.Data;

@Data
public class AtndDTO {

    private int no;
    private int mNo;
    private String startTime;
    private String endTime;
    private String state;
    private String today;

}
