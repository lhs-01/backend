package com.engis.esd.hrms.users;

import com.engis.esd.hrms.users.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserDTO getUser(String userId, String userPwd);

}
