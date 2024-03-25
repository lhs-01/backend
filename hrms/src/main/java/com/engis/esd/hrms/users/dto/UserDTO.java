package com.engis.esd.hrms.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int no;
    private String userId;
    private String userPwd;
    private String userNm;
    private Date userDate;
    private String userStatus;
    private int roleId;

}
