package com.kevten22.taigaspring.repository;

import com.kevten22.taigaspring.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orderrepository extends JpaRepository<Order, Long> {
}
