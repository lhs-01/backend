package com.engis.esd.hrms.cmt;

import com.engis.esd.hrms.cmt.dto.CmtDTO;
import com.engis.esd.hrms.users.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {

    List<UserDTO> getUser();

    CmtDTO findUserTime(int userNo);

    void setWorkStart(CmtDTO cmt);

    void setWorkEnd(CmtDTO cmt);
}
