package com.project.Repositories;

import com.project.Model.AddressType;
import com.project.POJOClasses.Address;
import com.project.ProjectApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {
        ProjectApplication.class,
        AddressRepository.class
})
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test(expected = DataAccessException.class)
    public void shouldNotSaveAddress(){
        Address address = new Address(AddressType.HOME, "lublin", "21-199", "niecala", "45");

        addressRepository.save(address);
    }
}