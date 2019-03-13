package com.kevten22.taigaspring.Controller;


import com.kevten22.taigaspring.models.Cart;
import com.kevten22.taigaspring.models.Order;
import com.kevten22.taigaspring.repository.Orderrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders/", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    Orderrepository orderrepos;

    @GetMapping("")
    public List<Order> listAllOrders()
    {
        return orderrepos.findAll();
    }

    @GetMapping(value = "/id/{orderid}")
    public Optional<Order> getOrderByOrderId(@PathVariable long cartid)
    {
        return orderrepos.findById(cartid);
    }

    @PostMapping("")
    public Order addNewOrder(@RequestBody Order neworder) throws URISyntaxException {
        return orderrepos.save(neworder);
    }
}
