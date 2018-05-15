package com.project.Controllers;

import com.project.POJOClasses.User;
import com.project.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public User add(
        @RequestBody User userRequest
    ){
        User user = new User(userRequest.getFirstName());
                userService.addUser(user);
                return user;
    }

}
