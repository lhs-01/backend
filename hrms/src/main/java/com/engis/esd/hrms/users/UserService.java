package com.engis.esd.hrms.users;

import com.engis.esd.hrms.users.dto.UserDTO;
import jakarta.servlet.http.HttpSession;

public interface UserService {
    UserDTO getUser(UserDTO userDTO);

    int logout(HttpSession session);
}
