package com.kevten22.taigaspring.repository;

import com.kevten22.taigaspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User, Long> {
   User findUserByUsername(String username);
}
