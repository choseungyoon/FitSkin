package com.fitksin.server.product.service;

import com.fitksin.server.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList(String param);

    boolean insertProduct(Product product);
}
