package com.project.Controllers;

import com.project.POJOClasses.Phone;
import com.project.Services.PhoneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("phones")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping(value = "/add")
    public Phone addPhone(
            @RequestBody Phone phoneRequest
    ) {
        Phone phone = new Phone(phoneRequest.getPhoneType(), phoneRequest.getPhoneNumber());
        phoneService.addPhone(phone);
        return phone;
    }

}
