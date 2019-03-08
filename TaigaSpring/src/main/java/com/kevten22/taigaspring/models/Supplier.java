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
    private String suppliername;
    private int supplystock;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "productsupplychain",
            joinColumns = {@JoinColumn(name = "supplierid")},
            inverseJoinColumns = {@JoinColumn(name = "productid")})
    @JsonIgnoreProperties("suppliers")
    private Set<Product> product;

    private Supplier(){
    }

    public long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(long supplierid) {
        this.supplierid = supplierid;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public int getSupplystock() {
        return supplystock;
    }

    public void setSupplystock(int supplystock) {
        this.supplystock = supplystock;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
