package com.project.Controllers;

import com.project.Model.UserType;
import com.project.Model.WrapperDto;
import com.project.POJOClasses.Address;
import com.project.POJOClasses.User;
import com.project.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/show/{id}")
    public User show(@PathVariable("id") long id){
        return userService.findUserById(id);
    }

    @PostMapping(value = "/add")
    public void addWatcher(
            @RequestBody WrapperDto request
            ){
        User user = request.getUser();
        user.getUserType();
        userService.addUser(
                new User(
                        user.getUserType(),
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

    @PostMapping(value = "update/{id}")
    public void updateUser(@RequestBody User request, @PathVariable("id") long id){
        userService.updateUser(request, id);
    }

}
