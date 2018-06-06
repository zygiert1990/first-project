package com.project.Controllers;

import com.project.Services.PhoneService;
import com.project.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user_phones")
public class PhoneAndUserController {
    private final UserService userService;
    private final PhoneService phoneService;

    public PhoneAndUserController(UserService userService, PhoneService phoneService) {
        this.userService = userService;
        this.phoneService = phoneService;
    }

}
