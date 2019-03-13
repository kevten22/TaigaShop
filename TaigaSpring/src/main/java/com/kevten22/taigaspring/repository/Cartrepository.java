package com.kevten22.taigaspring.repository;

import com.kevten22.taigaspring.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cartrepository extends JpaRepository<Cart, Long> {
}
