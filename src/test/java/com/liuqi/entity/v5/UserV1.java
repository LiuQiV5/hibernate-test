package com.liuqi.entity.v5;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class UserV1 implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    @AttributeOverrides({
            @AttributeOverride(name = "street",column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name = "zipcode",column = @Column(name = "BILLING_ZIPCODE",length = 5)),
            @AttributeOverride(name = "city",column = @Column(name = "BILLING_CITY"))
    })
    protected AddressV1 billingAddress;

    public Long getId() {
        return id;
    }

    public AddressV1 getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressV1 billingAddress) {
        this.billingAddress = billingAddress;
    }
}
