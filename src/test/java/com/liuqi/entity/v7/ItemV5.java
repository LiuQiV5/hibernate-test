package com.liuqi.entity.v7;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class ItemV5 {

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

    @OneToMany(mappedBy = "v5",cascade = CascadeType.ALL)
    protected Set<BidV1> bidV1s = new HashSet<>(10);

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

    public Set<BidV1> getBidV1s() {
        return bidV1s;
    }

    public void setBidV1s(Set<BidV1> bidV1s) {
        this.bidV1s = bidV1s;
    }
}
