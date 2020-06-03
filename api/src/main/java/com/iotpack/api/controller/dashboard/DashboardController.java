package com.iotpack.api.controller.dashboard;

import com.iotpack.api.controller.BaseController;
import com.iotpack.api.dto.ResDto;
import com.iotpack.api.service.AuthService;
import com.iotpack.api.service.DashboardService;
import com.iotpack.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DashboardController extends BaseController {

    @Autowired
    DashboardService dashboardService;

    @RequestMapping("/organization")
    public ResDto group(@RequestParam("organization_id") Long organizationId) {
        return success(dashboardService.getOrganizationIdData(organizationId));
    }

    @RequestMapping("/project")
    public ResDto project(@RequestParam("project_id") Long projectId) {
        return success(dashboardService.getProjectData(projectId));
    }

}
