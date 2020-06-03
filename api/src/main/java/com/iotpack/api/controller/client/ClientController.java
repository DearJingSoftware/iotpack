package com.iotpack.api.controller.client;

import com.iotpack.api.controller.BaseController;
import com.iotpack.api.dto.ResDto;
import com.iotpack.api.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClientController extends BaseController {

}
