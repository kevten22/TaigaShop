package com.kevten22.taigaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;

    private Boolean shippedstatus;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("orders")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Cart cart;

    private double orderTotal;

    private Order() {

    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public Boolean getShippedstatus() {
        return shippedstatus;
    }

    public void setShippedstatus(Boolean shippedstatus) {
        this.shippedstatus = shippedstatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;

    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
