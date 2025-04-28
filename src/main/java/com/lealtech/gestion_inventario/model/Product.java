package com.lealtech.gestion_inventario.model;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price; // Price with safe decimals

    @Column(nullable = false)
    private Integer stock; //Quantity in inventory

    @ManyToOne
    @JoinColumn(name = "category_id",  nullable = true)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id",  nullable = true)
    private Supplier supplier;


}
