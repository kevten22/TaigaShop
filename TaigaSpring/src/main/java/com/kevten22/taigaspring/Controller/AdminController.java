package com.kevten22.taigaspring.Controller;

import com.kevten22.taigaspring.models.User;
import com.kevten22.taigaspring.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    @Autowired
    Userrepository userrepos;

    @PostMapping("/user/")
    public User addNewUser(@RequestBody User newuser) throws URISyntaxException {
        return userrepos.save(newuser);
    }
}
