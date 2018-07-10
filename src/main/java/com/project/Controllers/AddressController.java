package com.project.Controllers;

import com.project.POJOClasses.Address;
import com.project.Services.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PutMapping(value = "/add/{city}")
    public Address addAddress(
            @PathVariable("city") String city
    ) {
        Address address = new Address(city);
        addressService.addAddress(address);
        return address;
    }

    @GetMapping(value = "/show/{city}")
    public Address showAddress(@PathVariable("city") String city) {
        return addressService.findByCity(city);
    }

    @PostMapping(value = "/save")
    public Address addWholeAddress(
            @RequestBody Address address
    ) {
        return addressService.addAddress(
                new Address(
                        address.getAddressType(),
                        address.getCity(),
                        address.getZipCode(),
                        address.getStreet(),
                        address.getHomeNumber()));
    }

}
