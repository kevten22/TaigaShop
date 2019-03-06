package com.kevten22.taigaspring.Controller;

import com.kevten22.taigaspring.models.Cart;
import com.kevten22.taigaspring.repository.Cartrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/carts/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController {
    @Autowired
    Cartrepository cartrepos;

    @GetMapping("")
    public List<Cart> listAllCarts()
    {
        return cartrepos.findAll();
    }

    @GetMapping(value = "/id/{cartid}")
    public Optional<Cart> getCartByCartId(@PathVariable long cartid)
    {
        return cartrepos.findById(cartid);
    }

    @PostMapping("")
    public Cart addNewCart(@RequestBody Cart newcart) throws URISyntaxException{
        return cartrepos.save(newcart);
    }

    @PutMapping("/{cartid}")
    public Cart changeCartById(@RequestBody Cart newcart, @PathVariable long cartid) throws URISyntaxException
    {
        Optional<Cart> updateCart = cartrepos.findById(cartid);
        if (updateCart.isPresent())
        {
            if (newcart.getCartitems() == null)
            {
                newcart.setCartitems(updateCart.get().getCartitems());
            }

            if (newcart.getOrder() == null)
            {
                newcart.setOrder(updateCart.get().getOrder());
            }
            newcart.setCartid(cartid);
            cartrepos.save(newcart);

            return newcart;
        }
        else
        {
            return null;
        }
    }
}
