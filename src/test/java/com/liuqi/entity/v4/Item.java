package com.liuqi.entity.v4;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "ID_GENERATOR")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO ,generator = "ID_GENERATOR")
    protected Long id;

    public Long getId(){
        return id;
    }
}
