package com.project.Services;

import com.project.Model.AddressType;
import com.project.Model.PhoneType;
import com.project.Model.UserType;
import com.project.POJOClasses.Address;
import com.project.POJOClasses.Phone;
import com.project.POJOClasses.User;
import com.project.ProjectApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {
        ProjectApplication.class,
        UserService.class,
        PhoneService.class,
        AddressService.class
})
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void couldFIndUserById(){
        //given
        User user = new User(UserType.DIRECTOR, "waclaw", "waclaw", LocalDate.now());
        Address address = new Address(AddressType.HOME, "lbn", "witosa", "122", "25");
        userService.addUser(user, address);
        entityManager.clear();
        //when
        User foundUser = userService.findUserById(user.getId());
        Address foundAddress = addressService.findAll().get(0);
        //then
        assertEquals(user.getFirstName(), foundUser.getFirstName());
        assertEquals(address.getCity(), foundAddress.getCity());
    }

 /*   @Test
    public void isUserPhoneListNotEmpty(){
        //given
        User user = new User(UserType.WATCHER, "some", "some", LocalDate.now());
        userService.addUser(user);
        Phone phone = new Phone(PhoneType.MOBILE, "555555555");
        phoneService.addPhone(phone, user.getId());
        entityManager.clear();
        //when
        User foundUser = userService.findUserById(user.getId());
        //then
        assertNotNull(foundUser.getPhones());
    }

    @Test
    public void doFindAllUserPhone(){
        //given
        User user = new User(UserType.WATCHER, "some", "some", LocalDate.now());
        userService.addUser(user);
        Phone phone = new Phone(PhoneType.MOBILE, "555555555");
        phoneService.addPhone(phone, user.getId());
        Phone phone1 = new Phone(PhoneType.MOBILE, "555555855");
        phoneService.addPhone(phone1, user.getId());
        entityManager.clear();
        List<Phone> allUserPhones = phoneService.findAllUserPhones(user.getId());
        assertEquals(2, allUserPhones.size());
    }

    @Test
    public void doFIndAllUsersPhoneWithoutExtraMethod(){
        //given
        User user = new User(UserType.WATCHER, "some", "some", LocalDate.now());
        userService.addUser(user);
        Phone phone = new Phone(PhoneType.MOBILE, "555555555");
        phoneService.addPhone(phone, user.getId());
        Phone phone1 = new Phone(PhoneType.MOBILE, "555555855");
        phoneService.addPhone(phone1, user.getId());
        entityManager.clear();
        List<Phone> allUserPhones = new ArrayList<>(userService.findUserById(user.getId()).getPhones());
        assertEquals(2, allUserPhones.size());
    }

    @Test
    public void isUserUpdated(){
        User user = new User(UserType.WATCHER, "some", "some", LocalDate.now());
        userService.addUser(user);
        userService.updateUser(new User(UserType.DIRECTOR, "michal", "michal", LocalDate.now()), user.getId());
        entityManager.clear();
        User foundUser = userService.findUserById(user.getId());
        assertEquals("michal", foundUser.getFirstName());
    }
*/
}