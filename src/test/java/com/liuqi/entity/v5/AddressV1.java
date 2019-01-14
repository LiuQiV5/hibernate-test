package com.liuqi.entity.v5;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressV1 {

    @NotNull
    @Column(nullable = false)
    protected String street;

    @NotNull
    @Column(nullable = false,length = 5)
    protected String zipcode;

    @NotNull
    @Column(nullable = false)
    protected String city;

    public AddressV1(){

    }

    public AddressV1(String street, String zipcode, String city) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
