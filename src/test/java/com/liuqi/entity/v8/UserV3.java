package com.liuqi.entity.v8;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERSV3")
public class UserV3 {

    @Id
    @GeneratedValue
    protected Long id;

    @OneToMany(mappedBy = "buyer")
    protected Set<ItemV1> boughtItems = new HashSet<>(10);
}
