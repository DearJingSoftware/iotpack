package com.iotpack.api.controller;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.form.auth.LoginForm;
import com.iotpack.api.form.auth.LogoutForm;
import com.iotpack.api.service.AuthService;
import com.iotpack.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    AuthService authService;


    @RequestMapping("/info")
    public Object login(){
        return success(  authService.getUserInfo());
    }

}
