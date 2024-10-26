//package com.lhakpa.ecommerce.Entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Set;
//
//@Entity
//@Table(name = "categories")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Category {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String name;
//
//    private String description;
//
//    // Bidirectional relationship with products
//// @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
// // private Set<Product> products;
//}
//
