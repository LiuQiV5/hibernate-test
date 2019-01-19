package com.liuqi.entity.v7;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ItemV3 {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @Column(name = "NAME",nullable = false)
    protected String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    //映射键
    @MapKeyColumn(name = "FILENAME")
    //映射值
    @Column(name = "IMAGENAME")
    protected Map<String,String> images = new HashMap<>();

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

    public Map<String, String> getImages() {
        return images;
    }

    public void setImages(Map<String, String> images) {
        this.images = images;
    }
}
