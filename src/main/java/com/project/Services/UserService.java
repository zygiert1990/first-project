package com.project.Services;

import com.project.POJOClasses.User;
import com.project.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public User findUserById(long id){
        return userRepository.findById(id);
    }

}
