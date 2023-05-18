package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Product;
import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Long> {
    Product findById(Long id);

    @Query("select p from Product p")
    List<Product> getAllProduct();
}
