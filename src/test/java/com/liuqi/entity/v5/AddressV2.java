package com.liuqi.entity.v5;

import com.sun.istack.internal.NotNull;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressV2 {

    @NotNull
    @Column(nullable = false)
    protected String street;

    @AttributeOverrides({
        @AttributeOverride(name = "name",column = @Column(name = "CITY",nullable = false))
    })
    protected City city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
