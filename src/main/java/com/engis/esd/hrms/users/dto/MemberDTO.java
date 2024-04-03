package com.engis.esd.hrms.users.dto;

import lombok.Data;

@Data
public class MemberDTO {

    private int no;
    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String address;
    private String grants;

}
