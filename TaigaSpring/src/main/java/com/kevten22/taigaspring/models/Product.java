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

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public int getQuantityonhand() {
        return quantityonhand;
    }

    public void setQuantityonhand(int quantityonhand) {
        this.quantityonhand = quantityonhand;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
