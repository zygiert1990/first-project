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

    @PostMapping(value = "/add")
    public User add(
            @RequestBody User userRequest
    ) {
        User user = new User(userRequest.getUserType(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getBirthDate());
        userService.addUser(user);
        return user;
    }

    @GetMapping(value = "/show/{id}")
    public User show(@PathVariable("id") long id){
        return userService.findUserById(id);
    }

}
