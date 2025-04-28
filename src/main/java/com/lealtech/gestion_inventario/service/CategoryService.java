package com.lealtech.gestion_inventario.service;

import com.lealtech.gestion_inventario.model.Category;
import com.lealtech.gestion_inventario.model.Product;
import com.lealtech.gestion_inventario.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Search product by name
    public Category searchCategory(String name){
        return categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    //save category in database
    public Category saveCategory(Category category) {
        System.out.println("Saving Category: " + category);
        return categoryRepository.save(category);
    }

    // show all category
    public List<Category> readCategory(){
        return categoryRepository.findAll();
    }

    //Update Product
    public Category updateCategory(String name, Category updatedData) {
        Category category = categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Cateogria no encontrada con nombre: " + name));

        // We update allowed fields
        category.setName(updatedData.getName());
        category.setDescription(updatedData.getDescription());

        return categoryRepository.save(category);
    }

    //Delete category
    public void deleteCategory(String name){
        if(!categoryRepository.existsByNameIgnoreCase(name)){
            throw new RuntimeException("Categoria no encontrada con nombre " + name);
        }
        categoryRepository.deleteByNameIgnoreCase(name);
    }
}
