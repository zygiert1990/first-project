package com.project.Services;

import com.project.POJOClasses.Phone;
import com.project.Repositories.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneService{
    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public void addPhone(Phone phone){
        phoneRepository.save(phone);
    }

    public void deletePhone(Phone phone){
        phoneRepository.delete(phone);
    }

    public Phone findPhoneByPhoneNumber(String phoneNumber){
        return phoneRepository.findByPhoneNumber(phoneNumber);
    }

}
