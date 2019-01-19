package com.liuqi.entity.v7;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ItemV4 {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @Column(name = "NAME")
    protected String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "FILENAME")
    @Column(name = "IMAGENAME")
    @org.hibernate.annotations.OrderBy(clause = "FILENAME desc")
    protected Map<String,String> map = new HashMap<>(6);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
