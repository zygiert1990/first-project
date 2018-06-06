package com.project.Controllers;

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

}
