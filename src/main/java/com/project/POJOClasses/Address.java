package com.project.POJOClasses;

import com.project.Model.AddressType;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address implements Comparable<Address>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private AddressType addressType;
    @Column(length = 45, nullable = false)
    private String city;
    @Column(length = 6, nullable = false)
    private String zipCode;
    @Column(length = 45, nullable = false)
    private String street;
    @Column(length = 5, nullable = false)
    private String homeNumber;
    @Column(length = 5)
    private String flatNumber;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Address(){}

    public Address(AddressType addressType, String city, String zipCode, String street, String homeNumber) {
        this.addressType = addressType;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.homeNumber = homeNumber;
    }

    public Address(String city){
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Address o) {
        return Integer.
                compare(
                        Integer.valueOf(Long.valueOf(this.id).toString()),
                        Integer.valueOf(Long.valueOf(o.getId()).toString()));
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressType=" + addressType +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getId() == address.getId() &&
                getAddressType() == address.getAddressType() &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getZipCode(), address.getZipCode()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getHomeNumber(), address.getHomeNumber()) &&
                Objects.equals(getFlatNumber(), address.getFlatNumber()) &&
                Objects.equals(getUser(), address.getUser());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getAddressType(), getCity(), getZipCode(), getStreet(), getHomeNumber(), getFlatNumber(), getUser());
    }
}
