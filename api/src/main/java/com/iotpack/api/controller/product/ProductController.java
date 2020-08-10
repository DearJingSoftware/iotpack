package com.iotpack.api.controller.product;

import com.iotpack.api.controller.BaseController;
import com.iotpack.api.controller.product.form.ProductListQueryForm;
import com.iotpack.api.dto.ResDto;
import com.iotpack.api.form.auth.QueryForm;
import com.iotpack.api.service.AuthService;
import com.iotpack.api.service.ProjectService;
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

    @Autowired
    ProjectService projectService;

    public ProductController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    AuthService authService;

    @RequestMapping("/list")
    public ResDto list(QueryForm query){
            return  success(projectService.list(query));
    }

    @RequestMapping("/all")
    public ResDto all(){
        return  success(projectService.all(authService.getUserInfo()));
    }

}
