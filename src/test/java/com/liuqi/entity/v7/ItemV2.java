package com.liuqi.entity.v7;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemV2 {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @Column(name = "NAME")
    protected String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    //启用持久化顺序，默认为images_order
    @OrderColumn
    @Column(name="FILENAME")
    protected List<String> images = new ArrayList<>();

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
