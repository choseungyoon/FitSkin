package com.fitksin.server.product.service.Impl;

import com.fitksin.server.product.model.Ingredient;
import com.fitksin.server.product.model.Product;
import com.fitksin.server.product.repository.IngredientRepository;
import com.fitksin.server.product.repository.ProductRepository;
import com.fitksin.server.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
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

        List<Product> allProduct = this.productRepository.findAll();
        List<Product> products = new ArrayList<>();
        int i = 0;
        for (Product product:
                allProduct) {
            if(i<8) {
                products.add(product);
                i++;
            }
            else{
                break;
            }
        }

        return allProduct;
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
        if(index.equals("전체")){
            return this.productRepository.findAll();
        }
        else if(index.equals("수분")){
            index = "M";
        }
        else if(index.equals("색소침착")){
            index = "P";
        }
        else if(index.equals("민감성")){
            index = "R";
        }
        else if(index.equals("트러블")){
            index = "T";
        }
        else if(index.equals("탄력")){
            index = "W";
        }
        else if(index.equals("피지분비")){
            index = "";
        }
        return this.productRepository.findByMainCodeContains(index);
    }

    @Override
    public List<Product> recommendProduct(String index){
        if(index.equals("전체")){
            return this.productRepository.findAll();
        }
        else if(index.equals("피부보습")){
            index = "M";
        }
        else if(index.equals("색소침착")){
            index = "P";
        }
        else if(index.equals("민감성")){
            index = "R";
        }
        else if(index.equals("트러블")){
            index = "T";
        }
        else if(index.equals("피부탄력")){
            index = "W";
        }
        else if(index.equals("피지분비")){
            index = "";
        }
        return this.productRepository.findTop10ByMainCodeContains(index);

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

    @Override
    public void makeProductFile(){
        List<Product> allProduct = this.productRepository.findAll();
        File file = new File("/Users/seungyuncho/Project/FitSkin-backend/crawler/product.txt");
        String str = "Hello world!";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (Product product:
                    allProduct) {
                writer.write(product.getName()+'\n');
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProductImage(){
        String filePath = "/Users/seungyuncho/Project/FitSkin-backend/crawler/output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = reader.readLine()) != null) {
                String name = str.split(",")[0];
                String image = str.split(",")[1];

                List<Product> products = this.productRepository.findByName(name);

                for (Product product:
                     products) {
                    if(image != null){
                        product.setImage(image);
                    }
                    this.productRepository.save(product);
                }
                System.out.println(str);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
