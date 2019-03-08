package com.kevten22.taigaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartid;

    @OneToMany(mappedBy = "cart")
    @JsonIgnoreProperties("cart")
    private Set<CartItem> cartitems;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("carts")
    private User user;

    @OneToOne
    @JoinColumn(name = "orderid")
    private Order order;

    public Cart() {
    }

    public long getCartid() {
        return cartid;
    }

    public void setCartid(long cartid) {
        this.cartid = cartid;
    }

    public Set<CartItem> getCartitems() {
        return cartitems;
    }

    public void setCartitems(Set<CartItem> cartitems) {
        this.cartitems = cartitems;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
