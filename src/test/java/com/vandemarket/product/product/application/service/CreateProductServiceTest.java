package com.vandemarket.product.product.application.service;

import com.vandemarket.product.product.application.port.in.command.CreateProductCommand;
import com.vandemarket.product.product.application.port.out.CreateProductPort;
import com.vandemarket.product.product.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CreateProductServiceTest {
    @InjectMocks
    private CreateProductService createProductService;
    @Mock
    private CreateProductPort createProductPort;
    @DisplayName("상품 등록 성공")
    @Test
    public void createProductServiceTest(){
        CreateProductCommand createProductCommand =
                CreateProductCommand.builder()
                        .name("IPhone 11")
                        .price(500000)
                        .description("아이폰 11 블랙, 3년전 구매 상태 S급")
                        .build();
        when(createProductPort.createProduct(any(Product.class))).thenReturn(true);
        // when
        createProductService.createProduct(createProductCommand);

        // then
        verify(createProductPort, times(1)).createProduct(any(Product.class));
    }
}
