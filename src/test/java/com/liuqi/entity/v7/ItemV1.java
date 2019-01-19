package com.liuqi.entity.v7;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ItemV1 {

    @Id
    @GeneratedValue
    protected Long id;

    @ElementCollection
    @CollectionTable(name = "IMAGE",joinColumns = @JoinColumn(name = "ITEM_ID"))
    @Column(name = "FILENAME")
    protected Set<String> images = new HashSet<>();
}
