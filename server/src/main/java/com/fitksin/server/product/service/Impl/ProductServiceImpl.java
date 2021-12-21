package com.fitksin.server.product.service.Impl;

import com.fitksin.server.product.model.Ingredient;
import com.fitksin.server.product.model.Product;
import com.fitksin.server.product.repository.IngredientRepository;
import com.fitksin.server.product.repository.ProductRepository;
import com.fitksin.server.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, IngredientRepository ingredientRepository){
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Product> getProductList(String param){
        List<Product> results = new ArrayList<>();
        try {
            if(!param.equals("")) {
                results = this.productRepository.findByNameContaining(param);
            }
        }
        catch (Exception ex){
        }

        return results;
    }

    @Override
    public List<Product> getProductAll(){
        return this.productRepository.findAll();
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

    @Override
    public boolean updateProduct(Product product){
        try {
            this.productRepository.save(product);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public Product getProduct(String id){
        Optional<Product> product = this.productRepository.findById(id);
        return product.isPresent() ? product.get() : null;
    }

    @Override
    public List<Product> getProductByIndex(String index){
        if(index.equals("피부보습")){
            index = "M";
        }
        else if(index.equals("피부 색소침착")){
            index = "P";
        }
        else if(index.equals("피부민감성")){
            //index = "R";
            index = "";
        }
        else if(index.equals("피부 트러블빈도")){
            index = "T";
        }
        else if(index.equals("피부탄력")){
            index = "W";
        }
        else{
            index = "";
        }

        return this.productRepository.findTop5ByIngredientCodeContains(index);
    }

    @Override
    public List<Ingredient> getIngredientAll(){
        return this.ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getIngredientByCode(String index){
        if(index.equals("피부보습")){
            index = "M";
        }
        else if(index.equals("피부 색소침착")){
            index = "P";
        }
        else if(index.equals("피부민감성")){
            //index = "R";
            index = "";
        }
        else if(index.equals("피부 트러블빈도")){
            index = "T";
        }
        else if(index.equals("피부탄력")){
            index = "W";
        }
        else{
            index = "";
        }
        return this.ingredientRepository.findTop3ByCodeContains(index);

    }
}
