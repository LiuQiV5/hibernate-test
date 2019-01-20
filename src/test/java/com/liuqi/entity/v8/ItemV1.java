package com.liuqi.entity.v8;

import javax.persistence.*;

@Entity
public class ItemV1 {

    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "ITEM_BUYER",
                joinColumns = @JoinColumn(name = "ITEM_ID"),
                inverseJoinColumns = @JoinColumn(nullable = false)
                )
    protected UserV3 buyer;
}
