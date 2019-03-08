package com.kevten22.taigaspring.Controller;

import com.kevten22.taigaspring.models.CartItem;
import com.kevten22.taigaspring.repository.CartItemrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cartitems/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartItemController {
    @Autowired
    CartItemrepository cartitemrepos;

    @GetMapping("")
    public List<CartItem> listAllCartItems()
    {
        return cartitemrepos.findAll();
    }

    @GetMapping(value = "/id/{cartitemid}")
    public Optional<CartItem> getCartItemByCartItemId(@PathVariable long cartitemid)
    {
        return cartitemrepos.findById(cartitemid);
    }
}