package com.engis.esd.hrms.atnd;

import com.engis.esd.hrms.atnd.dto.AtndDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AtndMapper {

    int insertAtnd (int memberNo);

    AtndDTO findAtnd(int memberNo);

    int updateStartTime(@Param("no") int no, @Param("state") String state);

    int updateEndTime(@Param("no") int no, @Param("state") String state);

    int updateState(@Param("no") int no, @Param("state") String state);
}
