package com.liuqi.entity.v8;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ItemV2 {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @Column(name = "NAME",nullable = false)
    protected String name;

    @ManyToMany(mappedBy = "items")
    protected Set<CategoryV1> categoryV1s = new HashSet<>(10);

    public ItemV2(String name) {
        this.name = name;
    }

    public ItemV2() {
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

    public Set<CategoryV1> getCategoryV1s() {
        return categoryV1s;
    }

    public void setCategoryV1s(Set<CategoryV1> categoryV1s) {
        this.categoryV1s = categoryV1s;
    }
}
