package com.kevten22.taigaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopper")
public class Shopper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopperid;
    private String username;

    @JsonIgnore
    private String password;
    private String role;

    private String billingaddress;
    private String shoppingaddress;
    private String phonenumber;
    private String paymentmethod;

    @OneToMany(mappedBy = "shopper")
    @JsonIgnoreProperties("shopper")
    private Set<Cart> carts = new HashSet<>();

    @OneToMany(mappedBy = "shopper")
    @JsonIgnoreProperties("shopper")
    private Set<Order> orders = new HashSet<>();

    public Shopper(){
    }


}
