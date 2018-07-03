package com.project.Services;

import com.project.Model.PhoneType;
import com.project.Model.UserType;
import com.project.POJOClasses.Phone;
import com.project.POJOClasses.User;
import com.project.ProjectApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {
        ProjectApplication.class,
        UserService.class,
        PhoneService.class
})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private PhoneService phoneService;

    @Test
    public void isUserSaveToDatabase(){
        //given
        User user = new User(UserType.DIRECTOR, "waclaw", "waclaw", LocalDate.now());
        userService.addUser(user);
        //when
        User foundUser = userService.findUserById(1);
        //then
        assertEquals(user.getFirstName(),foundUser.getFirstName());
    }

    @Test
    public void isUserPhoneListNotEmpty(){
        //given
        User user = new User(UserType.WATCHER, "some", "some", LocalDate.now());
        userService.addUser(user);
        Phone phone = new Phone(PhoneType.MOBILE, "555555555");
        phoneService.addPhone(phone, 2);

        //when
        User foundUser = userService.findUserById(2);
        Phone foundPhone = phoneService.findPhoneById(1);

        //then
        assertNotNull(foundUser.getPhones());
        assertEquals(phone.getPhoneNumber(), foundPhone.getPhoneNumber());

    }

}