package com.vandemarket.productservice.product.application.service;

import com.vandemarket.productservice.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.productservice.product.application.port.in.GetProductListQuery;
import com.vandemarket.productservice.product.application.port.in.GetProductQuery;
import com.vandemarket.productservice.product.application.port.out.LoadProductPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class LoadProductServiceTest {
    @InjectMocks
    private LoadProductService loadProductService;

    @Mock
    private LoadProductPort loadProductPort;

    @Test
    @DisplayName("상품 단일 조회 성공")
    public void getProductTest(){
        //given
        Long productId = 1L;
        GetProductQuery getProductQuery = GetProductQuery.builder()
                .productId(productId)
                .build();
        ProductResponse productResponse = ProductResponse.builder()
                .id(productId)
                .name("IPhone 12")
                .description("3년전에 구매")
                .price(300000)
                .build();
        when(loadProductPort.loadByGetProductQuery(getProductQuery)).thenReturn(productResponse);
        //when
        loadProductService.getProduct(getProductQuery);
        //then
        verify(loadProductPort, times(1)).loadByGetProductQuery(getProductQuery);
    }
    @Test
    @DisplayName("상품 목록 조회 성공")
    public void getProductListTest(){
        //given
        String name = "IPhone";
        GetProductListQuery getProductListQuery = GetProductListQuery.builder()
                .name(name)
                .build();
        when(loadProductPort.searchProductListQuery(any(GetProductListQuery.class))).thenReturn(any());

        //when
        loadProductService.getProductList(getProductListQuery);

        //then
        verify(loadProductPort, times(1)).searchProductListQuery(getProductListQuery);

    }
}
