package com.kevten22.taigaspring.repository;

import com.kevten22.taigaspring.models.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Shopperrepository extends JpaRepository<Shopper, Long> {
    List<Shopper> findShopperByUsername(String username);
}
