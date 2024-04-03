package com.engis.esd.hrms.users;

import com.engis.esd.hrms.users.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    MemberDTO getMember(@Param("id") String userId, @Param("pwd") String userPwd);

}
