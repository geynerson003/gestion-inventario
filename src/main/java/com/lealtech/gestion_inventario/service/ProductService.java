package com.lealtech.gestion_inventario.service;

import com.lealtech.gestion_inventario.model.Product;
import com.lealtech.gestion_inventario.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private final ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    //Search product by name
    public Product searchProduct(String name){
        return productsRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    //save product in database
    public Product saveProduct(Product product) {
        System.out.println("Saving product: " + product);
        return productsRepository.save(product);
    }

    // show all products
    public List<Product> readProduct(){
        return productsRepository.findAll();
    }

    //Update Product
    public Product updateProduct(String name, Product updatedData) {
        Product product = productsRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con nombre: " + name));

        // We update allowed fields
        product.setDescription(updatedData.getDescription());
        product.setPrice(updatedData.getPrice());
        product.setStock(updatedData.getStock());
        product.setCategory(updatedData.getCategory());
        product.setSupplier(updatedData.getSupplier());

        return productsRepository.save(product);
    }

    //Delete product
    public void deleteProduct(String name){
        if(!productsRepository.existsByNameIgnoreCase(name)){
            throw new RuntimeException("Producto no encontrado con de nombre " + name);
        }
        productsRepository.deleteByNameIgnoreCase(name);
    }

}
