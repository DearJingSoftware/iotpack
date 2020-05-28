package com.iotpack.api.controller;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.form.auth.LoginForm;
import com.iotpack.api.form.auth.LogoutForm;
import com.iotpack.api.service.AuthService;
import com.iotpack.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController extends BaseController {

    private final UserService userService;

    @Autowired
    AuthService authService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public Object login(@RequestBody LoginForm loginForm){
        LoginDto loginDto=userService.login(loginForm);
        return success(loginDto);
    }

    @RequestMapping("/logout")
    public Object logout(){

        return success(userService.logout(authService.getUserInfo()));
    }




}
