package com.lealtech.gestion_inventario.service;

import com.lealtech.gestion_inventario.model.Product;
import com.lealtech.gestion_inventario.model.Supplier;
import com.lealtech.gestion_inventario.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    //Search supplier by name
    public Supplier searchSupplier(String name){
        return supplierRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    //save supplier in database
    public Supplier saveSupplier(Supplier supplier) {
        System.out.println("Saving Supplier: " + supplier);
        return supplierRepository.save(supplier);
    }

    // show all suppliers
    public List<Supplier> readSupplier(){
        return supplierRepository.findAll();
    }

    //update suppliers
    public Supplier updateSupplier(String name, Supplier updatedData) {
        Supplier supplier = supplierRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado de nombre: " + name));

        // We update allowed fields
        supplier.setName(updatedData.getName());
        supplier.setContact(updatedData.getContact());
        supplier.setAddress(updatedData.getAddress());

        return supplierRepository.save(supplier);
    }

    //Delete supplier
    public void deleteSupplier(String name){
        if(!supplierRepository.existsByNameIgnoreCase(name)){
            throw new RuntimeException("Proveedor no encontrado de nombre " + name);
        }
        supplierRepository.deleteByNameIgnoreCase(name);
    }
}
