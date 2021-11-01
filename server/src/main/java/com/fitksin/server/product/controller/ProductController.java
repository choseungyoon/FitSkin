package com.fitksin.server.product.controller;

import com.fitksin.server.common.domain.Result;
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

    @GetMapping(value = "")
    public List<Product> getProductList(@RequestParam String param){
        return this.productService.getProductList(param);
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
}
