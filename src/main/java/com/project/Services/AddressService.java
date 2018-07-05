package com.project.Services;

import com.project.POJOClasses.Address;
import com.project.Repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findByCity(String city){
        return addressRepository.findByCity(city);
    }

}
