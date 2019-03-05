package com.kevten22.taigaspring.repository;

import com.kevten22.taigaspring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepository extends JpaRepository<Product, Long> {
}
