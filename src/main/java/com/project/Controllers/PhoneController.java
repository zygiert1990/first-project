package com.project.Controllers;

import com.project.POJOClasses.Phone;
import com.project.Services.PhoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("phones")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping(value = "/add/{id}")
    public void addMobilePhone(
            @RequestBody Phone phoneRequest,
            @PathVariable("id") long userId
    ){
        phoneService.addPhone(phoneRequest, userId);
    }

}
