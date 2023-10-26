package com.vandemarket.product.product.adapter.in.web;

import com.vandemarket.product.product.adapter.in.web.request.ProductCreateRequest;
import com.vandemarket.product.product.application.port.in.CreateProductUseCase;
import com.vandemarket.product.product.application.port.in.command.CreateProductCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @Mock
    private CreateProductUseCase createProductUseCase;
    @InjectMocks
    private ProductController productController;
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

}

