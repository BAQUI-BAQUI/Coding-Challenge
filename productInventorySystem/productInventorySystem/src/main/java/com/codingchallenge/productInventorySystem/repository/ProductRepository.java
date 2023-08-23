package com.codingchallenge.productInventorySystem.repository;

import com.codingchallenge.productInventorySystem.model.ProductData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductData, Integer> {

}
