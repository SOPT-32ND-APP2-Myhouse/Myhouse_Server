package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Product;
import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Long> {

    @Query("select p from Product p")
    Optional<List<Product>> getAllProduct();

}
