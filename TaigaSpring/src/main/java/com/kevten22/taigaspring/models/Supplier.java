package com.kevten22.taigaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierid;
    private int supplystock;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "productsupplychain",
            joinColumns = {@JoinColumn(name = "supplierid")},
            inverseJoinColumns = {@JoinColumn(name = "productid")})
    @JsonIgnoreProperties("suppliers")
    private Set<Product> product;

    private Supplier(){
    }
}
