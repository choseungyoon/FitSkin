package com.fitksin.server.product.repository;

import com.fitksin.server.product.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    List<Ingredient> findTop3ByCodeContains(String index);
}
