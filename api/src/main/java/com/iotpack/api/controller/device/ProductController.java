package com.iotpack.api.controller.device;

import com.iotpack.api.controller.BaseController;
import com.iotpack.api.service.AuthService;
import com.iotpack.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController extends BaseController {

    private final UserService userService;

    public ProductController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    AuthService authService;



}
