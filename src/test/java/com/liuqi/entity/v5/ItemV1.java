package com.liuqi.entity.v5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemV1 {

    @Id
    @GeneratedValue
    protected Long id;

    protected DimensionsV1 dimensionsV1;

    protected WeightV1 weightV1;
}
