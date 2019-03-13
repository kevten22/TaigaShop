package com.kevten22.taigaspring.repository;

import com.kevten22.taigaspring.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Supplierrepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findSupplierBySuppliernameEquals(String name);
}
