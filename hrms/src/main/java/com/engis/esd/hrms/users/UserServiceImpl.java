package com.engis.esd.hrms.users;

import com.engis.esd.hrms.users.dto.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public UserDTO getUser(UserDTO userDTO) {
        String userId = userDTO.getUserId();
        String userPwd = userDTO.getUserPwd();
        return userMapper.getUser(userId, userPwd);
    }

    @Override
    public int logout(HttpSession session) {
        return 0;
    }
}
