package com.kevten22.taigaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    private String username;

    @JsonIgnore
    private String password;
    private String role;

    private String billingaddress;
    private String shoppingaddress;
    private String phonenumber;
    private String paymentmethod;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<Cart> carts = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<Order> orders = new HashSet<>();

    public User(){
    }

    public long getShopperid() {
        return userid;
    }

    public void setShopperid(long shopperid) {
        this.userid = shopperid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public String getShoppingaddress() {
        return shoppingaddress;
    }

    public void setShoppingaddress(String shoppingaddress) {
        this.shoppingaddress = shoppingaddress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public List<SimpleGrantedAuthority> getAuthority(){
        String myRole = "ROLE_" + this.role.toUpperCase();
        return Arrays.asList(new SimpleGrantedAuthority(myRole));
    }
}
