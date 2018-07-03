package com.project.POJOClasses;

import com.project.Model.PhoneType;

import javax.persistence.*;

@Entity
public class Phone implements Comparable<Phone>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private PhoneType phoneType;
    @Column(length = 9, unique = true, nullable = false)
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Phone(){}

    public Phone(PhoneType phoneType, String phoneNumber) {
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
    }

    public Phone(PhoneType phoneType, String phoneNumber, User user) {
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Phone o) {
        return Integer.
                compare(
                    Integer.valueOf(Long.valueOf(this.id).toString()),
                    Integer.valueOf(Long.valueOf(o.getId()).toString()));
    }
}
