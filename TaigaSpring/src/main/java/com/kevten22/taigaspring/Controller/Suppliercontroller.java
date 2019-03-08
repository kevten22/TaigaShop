package com.kevten22.taigaspring.Controller;


import com.kevten22.taigaspring.models.Supplier;
import com.kevten22.taigaspring.repository.Supplierrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/suppliers/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Suppliercontroller {

    @Autowired
    Supplierrepository supplierrepos;

    @GetMapping("")
    public List<Supplier> listAllCourses()
    {
        return supplierrepos.findAll();
    }

    @GetMapping(value = "/id/{supplierid}")
    public Optional<Supplier> getCourseByCourseId(@PathVariable long supplierid)
    {
        return supplierrepos.findById(supplierid);
    }

    @GetMapping(value = "/name/{suppliername}")
    public List<Supplier> getSupplierBySupplierName(@PathVariable String suppliername)
    {
        return supplierrepos.findSupplierBySuppliernameEquals(suppliername);
    }
}
