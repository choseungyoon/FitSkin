package com.fitksin.server.product.service;

import com.fitksin.server.product.model.Ingredient;
import com.fitksin.server.product.model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getProductList(String param);
    boolean insertProduct(Product product);
    boolean updateProduct(Product product);
    List<Product> getProductAll();
    Product getProduct(String id);
    List<Product> getProductByIndex(String index);
    List<Product> recommendProduct(String index) throws IOException;
    List<Ingredient> getIngredientAll();
    List<Ingredient> getIngredientByCode(String index);
    void makeProductFile();
    void updateProductImage();
}
