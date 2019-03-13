package com.kevten22.taigaspring.Controller;

import com.kevten22.taigaspring.models.User;
import com.kevten22.taigaspring.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class Usercontroller {
    @Autowired
    Userrepository userrepos;

    @GetMapping("")
    public List<User> listAllShoppers()
    {
        return userrepos.findAll();
    }

    @GetMapping(value = "/id/{userid}")
    public Optional<User> getShopperByShopperId(@PathVariable long userid)
    {
        return userrepos.findById(userid);
    }

    @GetMapping(value = "/name/{username}")
    public User getShopperByUserName(@PathVariable String username)
    {
        return userrepos.findUserByUsername(username);
    }
}
