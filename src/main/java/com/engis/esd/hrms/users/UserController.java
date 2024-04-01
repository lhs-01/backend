package com.engis.esd.hrms.users;

import com.engis.esd.hrms.users.dto.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "http://192.168.0.30")
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO userDTO, HttpSession session) {
        String userId = userDTO.getUserId();
        String userPwd = userDTO.getUserPwd();

        UserDTO user = userService.getUser(userDTO);
        if(user != null) session.setAttribute("userId", userId);

        return user;
    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session, ModelAndView mv) {
        userService.logout(session);
        mv.setViewName("/user/login");
        mv.addObject("message", "logout");
        return mv;
    }

}
