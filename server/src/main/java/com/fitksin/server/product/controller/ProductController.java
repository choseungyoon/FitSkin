package com.fitksin.server.product.controller;

import com.fitksin.server.common.domain.Result;
import com.fitksin.server.product.model.Ingredient;
import com.fitksin.server.product.model.Product;
import com.fitksin.server.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/search")
    public List<Product> getProductList(@RequestParam String param){
        return this.productService.getProductList(param);
    }

    @GetMapping(value = "/all")
    public List<Product> getProductAll(){
        return this.productService.getProductAll();
    }

    @GetMapping(value = "/search/index")
    public List<Product> getProductByIndex(@RequestParam String index){
        return this.productService.getProductByIndex(index);
    }

    @GetMapping(value = "/ingredient/recommend")
    public List<Ingredient> recommendIngredient(@RequestParam String index){
        return this.productService.getIngredientByCode(index);
    }

    @GetMapping(value = "")
    public Result getProduct(@RequestParam String id){
        log.info("param : " + id);
        Result result = Result.successInstance();
        result.setData(
                this.productService.getProduct(id)
        );
        return result;
    }

    @PostMapping(value = "")
    public Result insertProduct(@RequestBody final Product product){
        log.info("param : " + product.getName());
        Result result = Result.successInstance();
        result.setData(
                this.productService.insertProduct(product)
        );
        return result;
    }

    @PutMapping(value = "")
    public Result updateProduct(@RequestBody final Product product){
        log.info("param : " + product.getName());
        Result result = Result.successInstance();
        result.setData(
                this.productService.updateProduct(product)
        );
        return result;
    }

    @GetMapping(value = "/ingredient")
    public Result getIngredientAll(){
        Result result = Result.successInstance();
        result.setData(
                this.productService.getIngredientAll()
        );
        return result;
    }

}
