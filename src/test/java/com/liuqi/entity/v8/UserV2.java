package com.liuqi.entity.v8;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "USERSV2")
public class UserV2 {

    @Id
    @GeneratedValue
    protected Long id;

    @OneToOne(mappedBy = "user",cascade = CascadeType.PERSIST)
    protected AddressV2 shippingAddress;

    @NotNull
    protected String username;

    public UserV2() {
    }

    public UserV2(AddressV2 shippingAddress, String username) {
        this.shippingAddress = shippingAddress;
        this.username = username;
    }

    public UserV2(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressV2 getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressV2 shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
