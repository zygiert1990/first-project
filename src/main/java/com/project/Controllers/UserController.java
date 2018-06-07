package com.project.Controllers;

import com.project.Model.UserType;
import com.project.POJOClasses.User;
import com.project.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public void addWatcher(@RequestBody User request){
        userService.addUser(
                new User(UserType.WATCHER, request.getFirstName(), request.getLastName(), request.getBirthDate()));
    }

    @PostMapping(value = "update/{id}")
    public void updateUser(@RequestBody User request, @PathVariable("id") long id){
        userService.updateUser(request, id);
    }

}
