package com.vandemarket.product.product.adapter.in.web;

import com.vandemarket.product.product.adapter.in.web.request.ProductCreateRequest;
import com.vandemarket.product.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.product.product.application.port.in.CreateProductUseCase;
import com.vandemarket.product.product.application.port.in.GetProductListQuery;
import com.vandemarket.product.product.application.port.in.GetProductQuery;
import com.vandemarket.product.product.application.port.in.GetProductUseCase;
import com.vandemarket.product.product.application.port.in.command.CreateProductCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @InjectMocks
    private ProductController productController;
    @Mock
    private CreateProductUseCase createProductUseCase;
    @Mock
    private GetProductUseCase getProductUseCase;

    @DisplayName("상품 등록 성공")
    @Test
    public void createProductTest(){
        ProductCreateRequest productCreateRequest = new ProductCreateRequest("IPhone 11", "3년됬음",300000);
        when(createProductUseCase.createProduct(any(CreateProductCommand.class))).thenReturn(true);
        // when
        productController.createProduct(productCreateRequest);
        // then
        verify(createProductUseCase, times(1)).createProduct(any(CreateProductCommand.class));

    }
    
    @DisplayName("상품 단일 조회 성공")
    @Test
    public void getProductByIdTest(){
        // given
        Long productId = 1L;
        ProductResponse productResponse = ProductResponse.builder()
                .id(productId)
                .name("IPhone 11")
                .description("3년됬음")
                .price(3000000)
                .build();
        when(getProductUseCase.getProduct(any(GetProductQuery.class))).thenReturn(productResponse);

        // when
        ResponseEntity<?> response = productController.getProductById(productId);

        //then
        verify(getProductUseCase, times(1)).getProduct(any(GetProductQuery.class));
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @DisplayName("상품 목록 조회 성공")
    @Test
    public void getProductList(){
        //given
        String name = "IPhone";
        when(getProductUseCase.getProduct(any())).thenReturn(any());
        //when
        ResponseEntity<?> response = productController.getProductList(name);
        //then
        verify(getProductUseCase, times(1)).getProductList(any(GetProductListQuery.class));
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}

