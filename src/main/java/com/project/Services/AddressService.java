package com.project.Services;

import com.project.POJOClasses.Address;
import com.project.Repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addAddress(Address address){
        addressRepository.save(address);
    }

    public void deleteAddress(Address address){
        addressRepository.delete(address);
    }

}
