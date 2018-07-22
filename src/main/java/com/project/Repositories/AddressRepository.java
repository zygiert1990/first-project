package com.project.Repositories;

import com.project.Model.AddressType;
import com.project.POJOClasses.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Override
    List<Address> findAll();

    Address findByCity(String city);

    Address findAddressByAddressType(AddressType addressType);

    Address findDistinctById(long id);

    Address findDistinctByCity(String city);

}
