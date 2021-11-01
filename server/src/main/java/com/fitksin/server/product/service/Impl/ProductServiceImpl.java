package com.fitksin.server.product.service.Impl;

import com.fitksin.server.product.model.Product;
import com.fitksin.server.product.repository.ProductRepository;
import com.fitksin.server.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList(String param){
        return null;
    }

    @Override
    public boolean insertProduct(Product product){
        try {
            this.productRepository.save(product);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

}
