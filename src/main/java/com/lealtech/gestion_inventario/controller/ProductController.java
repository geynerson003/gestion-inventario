package com.lealtech.gestion_inventario.controller;

import com.lealtech.gestion_inventario.model.Product;
import com.lealtech.gestion_inventario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {


    private final  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/buscar")
    public ResponseEntity<Product> searchProduct(@RequestParam String name) {
        Product product = productService.searchProduct(name);
        return ResponseEntity.ok(product);
    }

    //save product in database
    @PostMapping("/guardar")
    public Product saveProduct(@RequestBody Product product) {
        System.out.println("Product received: " + product.getName());
        return productService.saveProduct(product);
    }

    // show all products
    @GetMapping("/todos")
    public List<Product> readProduct(){
        return productService.readProduct();
    }

    //Update Product
    @PutMapping("/actualizar")
    public ResponseEntity<Product> updateProduct(
            @RequestParam String name,
            @RequestBody Product updatedData) {

        Product updated = productService.updateProduct(name, updatedData);
        return ResponseEntity.ok(updated);
    }

    //Delete product
    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> deleteProduct(@RequestParam String name) {
        productService.deleteProduct(name);
        return ResponseEntity.noContent().build();
    }


}

