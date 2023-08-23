package com.codingchallenge.productInventorySystem.controller;

import com.codingchallenge.productInventorySystem.model.ProductData;
import com.codingchallenge.productInventorySystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductData>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductData> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProductData> addProduct(@RequestBody ProductData productData){
        return new ResponseEntity<>(productService.saveProduct(productData), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductData> updateProduct(@RequestBody ProductData productData, @PathVariable Integer id){
        return new ResponseEntity<>(productService.updateProduct(productData, id), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.ACCEPTED);
    }
}
