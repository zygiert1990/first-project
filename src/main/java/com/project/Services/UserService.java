package com.project.Services;

import com.project.POJOClasses.User;
import com.project.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateUser(User user, long id){
        User userToUpdate = userRepository.findById(id);
        if (user.getFirstName()!=null) userToUpdate.setFirstName(user.getFirstName());
        if (user.getLastName()!=null) userToUpdate.setLastName(user.getLastName());
        if (user.getBirthDate()!=null) userToUpdate.setBirthDate(user.getBirthDate());
        userRepository.flush();
    }

    public List<User> findAllUsers() { return userRepository.findAll(); }

}
