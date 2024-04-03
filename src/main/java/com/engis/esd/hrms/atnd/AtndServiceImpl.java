package com.engis.esd.hrms.atnd;

import com.engis.esd.hrms.atnd.dto.AtndDTO;
import com.engis.esd.hrms.atnd.repository.AtndRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AtndServiceImpl implements AtndService {


    private final AtndRepository atndRepository;

    @Autowired
    public AtndServiceImpl(AtndRepository atndRepository) {
        this.atndRepository = atndRepository;
    }

    @Override
    public int insertAtnd(int memberNo) {
        return atndRepository.insertAtnd(memberNo);
    }

    @Override
    public AtndDTO findAtnd(int memberNo) {
        return atndRepository.findAtnd(memberNo);
    }

    @Override
    public int updateStartTime(int no, String state) {
        return atndRepository.updateStartTiem(no, state);
    }

    @Override
    public int updateEndTime(int no, String state) {
        return atndRepository.updateEndTime(no, state);
    }

    @Override
    public int updateState(int no, String state) {
        return atndRepository.updateState(no, state);
    }
}
