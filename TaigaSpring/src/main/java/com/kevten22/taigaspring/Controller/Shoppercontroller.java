package com.kevten22.taigaspring.Controller;

import com.kevten22.taigaspring.models.Shopper;
import com.kevten22.taigaspring.repository.Shopperrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/shoppers", produces = MediaType.APPLICATION_JSON_VALUE)
public class Shoppercontroller {
    @Autowired
    Shopperrepository shopperrepos;

    @GetMapping("")
    public List<Shopper> listAllShoppers()
    {
        return shopperrepos.findAll();
    }

    @GetMapping(value = "/id/{shopperid}")
    public Optional<Shopper> getShopperByShopperId(@PathVariable long shopperid)
    {
        return shopperrepos.findById(shopperid);
    }

    @GetMapping(value = "/name/{shoppername}")
    public List<Shopper> getShopperByUserName(@PathVariable String username)
    {
        return shopperrepos.findShopperByUsername(username);
    }
}
