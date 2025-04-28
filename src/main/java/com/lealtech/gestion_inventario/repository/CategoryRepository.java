package com.lealtech.gestion_inventario.repository;

import com.lealtech.gestion_inventario.model.Category;
import com.lealtech.gestion_inventario.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameIgnoreCase(String name);

    @Transactional
    void deleteByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

}
