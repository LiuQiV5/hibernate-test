package com.liuqi.entity.v8;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CategoryV1 {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @Column(name = "NAME",nullable = false)
    protected String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CATEGORY_ITEM",
                joinColumns = @JoinColumn(name = "CATEGORY_ID"),
                inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
              )
    protected Set<ItemV2> items = new HashSet<>(10);


    public CategoryV1() {
    }

    public CategoryV1(String name) {
        this.name = name;
    }

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

    public Set getItems() {
        return items;
    }

    public void setItems(Set items) {
        this.items = items;
    }
}
