package com.project.Services;

import com.project.Model.AddressType;
import com.project.POJOClasses.Address;
import com.project.Repositories.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(classes = {
        AddressService.class
})
@RunWith(SpringRunner.class)
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @MockBean
    private AddressRepository addressRepository;

    @Before
    public void setUp(){
        Address address = new Address(
                AddressType.HOME, "lbn", "20-200", "wil", "25"
        );
        Mockito.when(addressRepository.findByCity(address.getCity()))
                .thenReturn(address);
        Mockito.when(addressRepository.findAll()).thenReturn(Collections.singletonList(address));
    }

    @Test
    public void whenValidCityFindCity(){
        String city = "lbn";
        Address foundAddress = addressService.findByCity(city);

        assertEquals(foundAddress.getCity(), city);
    }

    @Test
    public void willFoundAllAddress(){
        List<Address> addresses = addressService.findAll();
        assertEquals(addresses.size(), 1);
    }

}