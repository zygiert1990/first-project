package com.project.Controllers;

import com.project.POJOClasses.Address;
import com.project.Services.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(value = "/add")
    public Address addAddress(
            @RequestBody Address addressRequest
    ){
        Address address = new Address(addressRequest.getCity());
        addressService.addAddress(address);
        return address;
    }

}
