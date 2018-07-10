package com.project.Controllers;

import com.project.Model.UserType;
import com.project.Model.WrapperDto;
import com.project.POJOClasses.Address;
import com.project.POJOClasses.User;
import com.project.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/show/{firstName}")
    public User show(@PathVariable("firstName") String firstName){
        return userService.findByFirstName(firstName);
    }

    @GetMapping(value = "/show/allUsers")
    public List<User> showAll(){
        return userService.findAllUsers();
    }

    @PostMapping(value = "/add")
    public void addWatcher(
            @RequestBody WrapperDto request
            ){
        userService.addUser(
                new User(
                        request.getUser().getUserType(),
                        request.getUser().getFirstName(),
                        request.getUser().getLastName(),
                        request.getUser().getBirthDate()),
                new Address(
                        request.getAddress().getAddressType(),
                        request.getAddress().getCity(),
                        request.getAddress().getZipCode(),
                        request.getAddress().getStreet(),
                        request.getAddress().getHomeNumber()));
    }

    @PostMapping(value = "/update/{id}")
    public void updateUser(@RequestBody User request, @PathVariable("id") long id){
        userService.updateUser(request, id);
    }

}
