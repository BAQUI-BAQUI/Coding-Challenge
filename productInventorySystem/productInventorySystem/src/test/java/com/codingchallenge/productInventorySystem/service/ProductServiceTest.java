package com.codingchallenge.productInventorySystem.service;

import com.codingchallenge.productInventorySystem.exception.RecordNotFoundException;
import com.codingchallenge.productInventorySystem.model.ProductData;
import com.codingchallenge.productInventorySystem.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static com.codingchallenge.productInventorySystem.enums.ProductType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService = new ProductServiceImpl();
    ProductData productTest1 = ProductData.builder()
            .productId(1)
            .productName("testProduct")
            .productDescription("testProductDesc")
            .productType(SPORTS)
            .unitPrice(6.00F)
            .build();

    ProductData productTest2 = ProductData.builder()
            .productId(2)
            .productName("testProduct2")
            .productDescription("testProductDesc2")
            .productType(ELECTRONIC)
            .unitPrice(7.00F)
            .build();

    ProductData productTest3 = ProductData.builder()
            .productId(3)
            .productName("testProduct3")
            .productDescription("testProductDesc3")
            .productType(MUSIC)
            .unitPrice(8.00F)
            .build();

    List<ProductData> productDataList = List.of(productTest1, productTest2, productTest3);

    @Test
    public void testGetAllproducts() {
        Mockito.when(productRepository.findAll()).thenReturn(productDataList);

        List<ProductData> getAll = productService.getAllProducts();

        assertThat(getAll).isNotNull();
        assertThat(getAll.size()).isEqualTo(3);
    }

    @Test
    public void testGetProductById() throws RecordNotFoundException {
        Mockito.when(productRepository.findById(anyInt())).thenReturn(Optional.ofNullable(productTest1));

        ProductData getById = productService.getProductById(1);

        assertThat(getById).isNotNull();
    }

    @Test
    public void testSaveProduct() {
        Mockito.when(productRepository.save(productTest1)).thenReturn(productTest1);

        ProductData save = productService.saveProduct(productTest1);

        assertThat(save).isNotNull();
    }

    @Test
    public void testUpdateProduct() {
        Mockito.when(productRepository.save(productTest1)).thenReturn(productTest1);

        Mockito.when(productRepository.findById(anyInt()))
                .thenReturn(Optional.ofNullable(productTest1));

        ProductData productTestUpdate = ProductData.builder()
                .productId(1)
                .productName("testProductUpdate")
                .productDescription("testProductDescUpdate")
                .productType(FOOD)
                .unitPrice(7.50F)
                .build();

        ProductData update = productService.updateProduct(productTestUpdate, 1);

        assertThat(update).isNotNull();
        assertThat(update).isEqualTo(productTestUpdate);
    }

    @Test
    public void testDeleteProduct() {
        Integer productId = 1;

        Mockito.doNothing().when(productRepository).deleteById(productId);

        productService.deleteProduct(productId);

        Mockito.verify(productRepository, times(1)).deleteById(productId);
    }
}
