package com.liuqi.entity.v5;

import com.sun.istack.internal.NotNull;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BillingDetailsV1 {

    @NotNull
    protected String owner;
}
