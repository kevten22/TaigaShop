package com.kevten22.taigaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "cartitem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartitemid;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productid")
    @JsonIgnoreProperties("cartiems")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cartid")
    @JsonIgnoreProperties("cartitems")
    private Cart cart;

    public CartItem() {
    }

}
