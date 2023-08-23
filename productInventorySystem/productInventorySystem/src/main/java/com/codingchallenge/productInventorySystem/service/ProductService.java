package com.codingchallenge.productInventorySystem.service;

import com.codingchallenge.productInventorySystem.model.ProductData;

import java.util.List;

public interface ProductService {
    List<ProductData> getAllProducts();
    ProductData getProductById(Integer id) ;
    ProductData saveProduct(ProductData productData);
    ProductData updateProduct(ProductData productData, Integer id);
    String deleteProduct(Integer id);
}
