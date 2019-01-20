package com.liuqi.entity.v8;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class AddressV2 {

    @Id
    @GeneratedValue(generator = "addressKeyGenerator")
    @GenericGenerator(name = "addressKeyGenerator",strategy = "foreign",parameters = @Parameter(name = "property",value = "user"))
    protected Long id;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    protected UserV2 user;

    @NotNull
    protected String street;

    @NotNull
    protected String zipcode;

    @NotNull
    protected String city;

    public AddressV2() {
    }

    public AddressV2(UserV2 user) {
        this.user = user;
    }

    public AddressV2(UserV2 user, String street, String zipcode, String city) {
        this.user = user;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }
}
