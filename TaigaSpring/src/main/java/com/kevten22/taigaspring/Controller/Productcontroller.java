package com.kevten22.taigaspring.Controller;

import com.kevten22.taigaspring.models.Product;
import com.kevten22.taigaspring.repository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/products/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Productcontroller {
    @Autowired
    Productrepository productrepos;

    @GetMapping("")
    public List<Product> listAllCourses(){
        return productrepos.findAll();
    }

    @GetMapping(value = "/id/{productid}")
    public Optional<Product> getProductByProductId(@PathVariable long productid){
        return productrepos.findById(productid);
    }

    @GetMapping(value = "/name/{productname}")
    public List<Product> getProductByProductName(@PathVariable String productname){
        return productrepos.findProductByProductnameEquals(productname);
    }


}
