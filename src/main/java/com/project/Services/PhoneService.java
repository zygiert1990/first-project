package com.project.Services;

import com.project.Model.PhoneType;
import com.project.POJOClasses.Phone;
import com.project.POJOClasses.User;
import com.project.Repositories.PhoneRepository;
import com.project.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneService{
    private final PhoneRepository phoneRepository;
    private final UserRepository userRepository;

    public PhoneService(PhoneRepository phoneRepository, UserRepository userRepository) {
        this.phoneRepository = phoneRepository;
        this.userRepository = userRepository;
    }

    public void addPhone(Phone phone, long userId) {
        User user = userRepository.findById(userId);
        Phone phoneToAdd = new Phone(phone.getPhoneType(), phone.getPhoneNumber(), user);
        user.getPhones().add(phoneToAdd);
        phoneRepository.save(phoneToAdd);
    }

    public void deletePhone(Phone phone){
        phoneRepository.delete(phone);
    }

    public Phone findPhoneByPhoneNumber(String phoneNumber){
        return phoneRepository.findByPhoneNumber(phoneNumber);
    }

}
