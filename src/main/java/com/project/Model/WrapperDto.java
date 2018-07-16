package com.project.Model;

import com.project.POJOClasses.Address;
import com.project.POJOClasses.User;

import java.io.Serializable;

public class WrapperDto implements Serializable {
    private User user;
    private Address address;

    public WrapperDto(User user, Address address) {
        this.user = user;
        this.address = address;
    }

    public WrapperDto(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
