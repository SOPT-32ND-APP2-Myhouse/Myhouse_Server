package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Long> {
    Product findById(Long id);
}
