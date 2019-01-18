package com.liuqi.entity.v5;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name",column = @Column(name = "WEIGHT_NAME")),
        @AttributeOverride(name = "symbol",column = @Column(name = "WEIGHT_SYMBOL"))
})
public class WeightV1 extends MeasurementV1 {

    @NotNull
    @Column(name = "WEIGHT")
    protected BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
