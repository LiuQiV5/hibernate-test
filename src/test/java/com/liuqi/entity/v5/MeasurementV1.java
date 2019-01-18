package com.liuqi.entity.v5;

import com.sun.istack.internal.NotNull;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MeasurementV1 {

    @NotNull
    protected String name;

    @NotNull
    protected String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
