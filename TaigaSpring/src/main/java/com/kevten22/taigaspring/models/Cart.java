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

}
