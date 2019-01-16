package com.liuqi.entity.v5;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "owner",column = @Column(name = "OWNER",nullable = false))
public class BankAccountV1 extends BillingDetailsV1 {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    protected String account;

    @NotNull
    protected String bankname;

    @NotNull
    protected String swift;
}
