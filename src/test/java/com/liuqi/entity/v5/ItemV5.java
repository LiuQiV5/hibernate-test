package com.liuqi.entity.v5;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "ID_GENERATOR")
public class ItemV5 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO ,generator = "ID_GENERATOR")
    protected Long id;

    @Column(name = "WEIGHT_G")
    @ColumnTransformer(read = "WEIGHT_G / 1000",write = "? * 1000")
    protected double weight_kg;

    public void setWeight_kg(double weight_kg) {
        this.weight_kg = weight_kg;
    }

    public double getWeight_kg() {
        return weight_kg;
    }
}
