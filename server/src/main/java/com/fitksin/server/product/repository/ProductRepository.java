package com.fitksin.server.product.repository;

import com.fitksin.server.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    List<Product> findByNameContaining(String name);

    List<Product> findByMainCodeContains(String code);

    List<Product> findTop10ByMainCodeContains(String code);

    List<Product> findByName(String name);

}
