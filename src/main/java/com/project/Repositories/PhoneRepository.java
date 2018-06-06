package com.project.Repositories;

import com.project.POJOClasses.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    Phone findByPhoneNumber(String phoneNumber);

}
