package com.project.Repositories;

import com.project.Model.PhoneType;
import com.project.POJOClasses.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    Phone findByPhoneNumber(String phoneNumber);

    Phone findById(long id);

    @Override
    List<Phone> findAll();

    Phone findByIdAndPhoneNumber(long id, String phoneNumber);

    Phone findDistinctById(long id);

    Phone findDistinctByPhoneNumber(String phoneNumber);

    Phone findDistinctByPhoneType(PhoneType phoneType);

}