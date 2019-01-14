package com.liuqi.entity.v5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "USERV2")
public class UserV2 implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    protected AddressV2 addressV2;

    public AddressV2 getAddressV2() {
        return addressV2;
    }

    public void setAddressV2(AddressV2 addressV2) {
        this.addressV2 = addressV2;
    }
}
