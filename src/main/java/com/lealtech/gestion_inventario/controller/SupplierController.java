package com.lealtech.gestion_inventario.controller;

import com.lealtech.gestion_inventario.model.Product;
import com.lealtech.gestion_inventario.model.Supplier;
import com.lealtech.gestion_inventario.service.ProductService;
import com.lealtech.gestion_inventario.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @GetMapping("/buscar")
    public ResponseEntity<Supplier> searchSupplier(@RequestParam String name) {
        Supplier supplier = supplierService.searchSupplier(name);
        return ResponseEntity.ok(supplier);
    }

    //save supplier in database
    @PostMapping("/guardar")
    public Supplier saveSupplier(@RequestBody Supplier supplier) {
        System.out.println("Supplier received: " + supplier.getName());
        return supplierService.saveSupplier(supplier);
    }

    // show all Suppliers
    @GetMapping("/todos")
    public List<Supplier> readSupplier(){
        return supplierService.readSupplier();
    }

    //Update Product
    @PutMapping("/actualizar")
    public ResponseEntity<Supplier> updateSupplier(
            @RequestParam String name,
            @RequestBody Supplier updatedData) {

       Supplier updated = supplierService.updateSupplier(name, updatedData);
        return ResponseEntity.ok(updated);
    }

    //Delete supplier
    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> deleteSupplier(@RequestParam String name) {
        supplierService.deleteSupplier(name);
        return ResponseEntity.noContent().build();
    }
}
