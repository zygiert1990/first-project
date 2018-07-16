package com.project.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Model.UserType;
import com.project.Model.WrapperDto;
import com.project.POJOClasses.Address;
import com.project.POJOClasses.User;
import com.project.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            ) {
        User user = request.getUser();
        Address address = request.getAddress();
        userService.addUser(user, address);
    }

    @PutMapping(value = "/update/{id}")
    public void updateUser(@RequestBody User request, @PathVariable("id") long id){
        userService.updateUser(request, id);
    }

}
