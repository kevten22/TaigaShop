package com.kevten22.taigaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;
    private String productname;
    private double productprice;
    private int quantityonhand;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Supplier> suppliers = new HashSet<>();

    public Product() {

    }
}
