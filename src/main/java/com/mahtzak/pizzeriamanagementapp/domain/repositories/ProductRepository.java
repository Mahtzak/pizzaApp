package com.mahtzak.pizzeriamanagementapp.domain.repositories;

import com.mahtzak.pizzeriamanagementapp.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(/*nativeQuery = true,
            value=*/"Update Product p set p.name= ?1, p.description=?2," +
                    "p.price=?3, p.type=?4 where p.id=?5")
    void editProduct(String name, String description, Double price, Integer type,
                     Long id);
}
