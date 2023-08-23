package com.codingchallenge.productInventorySystem.model;

import com.codingchallenge.productInventorySystem.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private String productDescription;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private Float unitPrice;
}
