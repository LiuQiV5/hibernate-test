package com.liuqi.entity.v8;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CategoryV2 {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @Column(name = "NAME",nullable = false)
    protected String name;

    @OneToMany(mappedBy = "categoryV2")
    protected Set<CategorizedItem> categorizedItems = new HashSet<>(10);

    public CategoryV2() {
    }

    public CategoryV2(String name) {
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

    public Set getCategorizedItems() {
        return categorizedItems;
    }

    public void setCategorizedItems(Set categorizedItems) {
        this.categorizedItems = categorizedItems;
    }
}
