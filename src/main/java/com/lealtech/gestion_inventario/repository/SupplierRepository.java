package com.lealtech.gestion_inventario.repository;

import com.lealtech.gestion_inventario.model.Product;
import com.lealtech.gestion_inventario.model.Supplier;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByNameIgnoreCase(String name);

    @Transactional
    void deleteByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

}
