package com.engis.esd.hrms.cmt;

import com.engis.esd.hrms.cmt.dto.CmtDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmtServiceImpl implements CmtService {


    private final CmtMapper cmtMapper;

    @Autowired
    public CmtServiceImpl(CmtMapper cmtMapper) {
        this.cmtMapper = cmtMapper;
    }


    @Override
    public CmtDTO findUserTime(int userNo) {
        return cmtMapper.findUserTime(userNo);
    }

    @Override
    public void setWorkStart(CmtDTO cmt) {
        cmtMapper.setWorkStart(cmt);
    }

    @Override
    public void setWorkEnd(CmtDTO cmt) {
        cmtMapper.setWorkEnd(cmt);
    }

}
