package com.project.Services;

import com.project.POJOClasses.Phone;
import com.project.Repositories.PhonesRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    private final PhonesRepository phonesRepository;

    public PhoneService(PhonesRepository phonesRepository) {
        this.phonesRepository = phonesRepository;
    }

    public void addPhone(Phone phone){
        phonesRepository.save(phone);
    }

    public void deletePhone(Phone phone){
        phonesRepository.delete(phone);
    }

}
