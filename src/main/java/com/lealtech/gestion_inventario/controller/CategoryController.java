package com.lealtech.gestion_inventario.controller;

import com.lealtech.gestion_inventario.model.Category;
import com.lealtech.gestion_inventario.model.Product;
import com.lealtech.gestion_inventario.repository.CategoryRepository;
import com.lealtech.gestion_inventario.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<Category> searchCategory(@RequestParam String name) {
        Category category = categoryService.searchCategory(name);
        return ResponseEntity.ok(category);
    }

    //save category in database
    @PostMapping("/guardar")
    public Category saveCategory(@RequestBody Category category) {
        System.out.println("Category received: " + category.getName());
        return categoryService.saveCategory(category);
    }

    // show all products
    @GetMapping("/todos")
    public List<Category> readCategory(){
        return categoryService.readCategory();
    }

    //Update Product
    @PutMapping("/actualizar")
    public ResponseEntity<Category> updateCategory(
            @RequestParam String name,
            @RequestBody Category updatedData) {

        Category updated = categoryService.updateCategory(name, updatedData);
        return ResponseEntity.ok(updated);
    }


    //Delete product
    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> deleteCategory(@RequestParam String name) {
        categoryService.deleteCategory(name);
        return ResponseEntity.noContent().build();
    }
}
