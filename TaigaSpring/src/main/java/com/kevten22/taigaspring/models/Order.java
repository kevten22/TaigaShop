package com.kevten22.taigaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;

    private Boolean shippedstatus;

    @ManyToOne
    @JoinColumn(name = "shopperid")
    @JsonIgnoreProperties("orders")
    private Shopper shopper;

    private double orderTotal;

    private Order() {

    }


}
