package com.kevten22.taigaspring.Controller;

import com.kevten22.taigaspring.models.Order;
import com.kevten22.taigaspring.models.Product;
import com.kevten22.taigaspring.models.Supplier;
import com.kevten22.taigaspring.repository.Orderrepository;
import com.kevten22.taigaspring.repository.Productrepository;
import com.kevten22.taigaspring.repository.Supplierrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/shopkeeper/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Shopkeepercontroller {
    //products, suppliers, orderstatus
    @Autowired
    Productrepository productrepos;
    @Autowired
    Supplierrepository supplierrepos;
    @Autowired

    Orderrepository orderrepos;
    @PutMapping("/product/{productid}")
    public Product changeProductById(@RequestBody Product newproduct, @PathVariable long productid) throws URISyntaxException
    {
        Optional<Product> updateProduct = productrepos.findById(productid);
        if (updateProduct.isPresent())
        {
            if (newproduct.getSuppliers() == null)
            {
                newproduct.setSuppliers(updateProduct.get().getSuppliers());
            }

            if (newproduct.getProductname() == null)
            {
                newproduct.setProductname(updateProduct.get().getProductname());
            }
            newproduct.setProductid(productid);
            productrepos.save(newproduct);

            return newproduct;
        }
        else
        {
            return null;
        }
    }

    @PutMapping("/suppliers/{supplierid}")
    public Supplier changeSupplierById(@RequestBody Supplier newsupplier, @PathVariable long supplierid) throws URISyntaxException
    {
        Optional<Supplier> updateSupplier = supplierrepos.findById(supplierid);
        if (updateSupplier.isPresent())
        {
            if (newsupplier.getProduct() == null)
            {
                newsupplier.setProduct(updateSupplier.get().getProduct());
            }

            if (newsupplier.getSuppliername() == null)
            {
                newsupplier.setSuppliername(updateSupplier.get().getSuppliername());
            }
            newsupplier.setSupplierid(supplierid);
            supplierrepos.save(newsupplier);

            return newsupplier;
        }
        else
        {
            return null;
        }
    }

    @PutMapping("/orders/{orderid}")
    public Order changeOrderById(@RequestBody Order neworder, @PathVariable long orderid) throws URISyntaxException
    {
        Optional<Order> updateOrder = orderrepos.findById(orderid);
        if (updateOrder.isPresent())
        {
            if (neworder.getShopper() == null)
            {
                neworder.setShopper(updateOrder.get().getShopper());
            }

            if (neworder.getCart() == null)
            {
                neworder.setCart(updateOrder.get().getCart());
            }
            neworder.setOrderid(orderid);
            orderrepos.save(neworder);

            return neworder;
        }
        else
        {
            return null;
        }
    }
}
