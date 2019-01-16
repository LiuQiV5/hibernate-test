package com.liuqi.entity.v5;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "owner",column = @Column(name = "CC_OWNER",nullable = false))
public class CreditCardV1 extends BillingDetailsV1 {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    protected String cardNumber;

    @NotNull
    protected String expMonth;

    @NotNull
    protected String expYear;
}
