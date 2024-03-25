package com.engis.esd.hrms.cmt;

import com.engis.esd.hrms.cmt.dto.CmtDTO;

public interface CmtService {

    CmtDTO findUserTime(int userNo);

    void setWorkStart(CmtDTO cmt);

    void setWorkEnd(CmtDTO cmt);
}
