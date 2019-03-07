package com.kevten22.taigaspring.service.impl;

import com.kevten22.taigaspring.models.User;
import com.kevten22.taigaspring.repository.Userrepository;
import com.kevten22.taigaspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService
{

    @Autowired
    private Userrepository userrepository;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException
    {
        User user = userrepository.findUserByUsername(userId);
        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
    }

    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userrepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id)
    {
        userrepository.deleteById(id);
    }

    @Override
    public User save(User user)
    {
        return userrepository.save(user);
    }
}

