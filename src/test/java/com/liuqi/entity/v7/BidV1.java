package com.liuqi.entity.v7;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class BidV1 {

    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID" ,nullable = false)
    protected ItemV5 v5;

    @NotNull
    @Column(name = "PRICE")
    protected BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ItemV5 getV5() {
        return v5;
    }

    public void setV5(ItemV5 v5) {
        this.v5 = v5;
    }
}
