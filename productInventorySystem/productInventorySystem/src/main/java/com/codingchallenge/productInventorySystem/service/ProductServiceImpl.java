package com.codingchallenge.productInventorySystem.service;

import com.codingchallenge.productInventorySystem.model.ProductData;
import com.codingchallenge.productInventorySystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository repository;

    @Override
    public List<ProductData> getAllProducts() {
        return (List<ProductData>) repository.findAll();
    }

    @Override
    public ProductData getProductById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public ProductData saveProduct(ProductData productData) {
        return repository.save(productData);
    }

    @Override
    public ProductData updateProduct(ProductData productData, Integer id) {
        ProductData productFound = repository.findById(id).orElseThrow();
        productFound.setProductName(productData.getProductName());
        productFound.setProductDescription(productData.getProductDescription());
        productFound.setProductType(productData.getProductType());
        productFound.setUnitPrice(productData.getUnitPrice());
        return repository.save(productFound);
    }

    @Override
    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product " + id + " has been deleted.";
    }
}
