package com.kevten22.taigaspring.repository;

import com.kevten22.taigaspring.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemrepository extends JpaRepository<CartItem, Long> {
}
