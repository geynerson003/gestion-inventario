package com.lealtech.gestion_inventario.repository;

import com.lealtech.gestion_inventario.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductsRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNameIgnoreCase(String name);

    @Transactional
    void deleteByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

}
