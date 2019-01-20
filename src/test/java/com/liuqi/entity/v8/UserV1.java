package com.liuqi.entity.v8;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserV1 {

    @Id
    protected Long id;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @PrimaryKeyJoinColumn
    protected AddressV1 shippingAddress;

    @NotNull
    protected String username;

    public UserV1(Long id,String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressV1 getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressV1 shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
