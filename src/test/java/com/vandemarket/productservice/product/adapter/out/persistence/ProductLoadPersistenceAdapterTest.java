package com.vandemarket.productservice.product.adapter.out.persistence;

import com.vandemarket.productservice.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.productservice.product.application.port.in.GetProductListQuery;
import com.vandemarket.productservice.product.application.port.in.GetProductQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductLoadPersistenceAdapterTest {
    @InjectMocks
    private ProductLoadPersistenceAdapter productLoadPersistenceAdapter;

    @Mock
    private SpringDataProductRepository springDataProductRepository;
    @Test
    @DisplayName("상품 단일 조회 - id 성공")
    public void loadByGetProductQueryTest(){
        // given
        Long targetId = 1L;
        GetProductQuery getProductQuery = GetProductQuery.builder()
                .productId(targetId)
                .build();
        Optional<ProductJpaEntity> productJpaEntity = Optional.of(ProductJpaEntity.builder()
                .id(targetId)
                .name("IPhone 12")
                .description("아이폰 상태좋음 S급")
                .price(300000)
                .build());
        ProductResponse expectedResponse = ProductResponse.builder()
                .id(targetId)
                .name(productJpaEntity.get().getName())
                .description(productJpaEntity.get().getDescription())
                .price(productJpaEntity.get().getPrice())
                .build();
        when(springDataProductRepository.findById(targetId)).thenReturn(productJpaEntity);
        // when
        ProductResponse returnedProductResponse = productLoadPersistenceAdapter.loadByGetProductQuery(getProductQuery);
        // then
        verify(springDataProductRepository, times(1)).findById(targetId);
        Assertions.assertEquals(returnedProductResponse.getId(), expectedResponse.getId());
    }
    
    @Test
    @DisplayName("상품 목록 조회 성공")
    public void searchProductListQueryTest(){
        //given
        GetProductListQuery query = GetProductListQuery.builder()
                .name("IPhone")
                .build();
        List<ProductJpaEntity> productJpaEntityList = Arrays.asList(
                ProductJpaEntity.builder()
                        .id(1L)
                        .name("IPhone 12")
                        .description("아이폰 상태좋음 S급")
                        .price(300000)
                        .build(),
                ProductJpaEntity.builder()
                        .id(2L)
                        .name("IPhone 13")
                        .description("아이폰 상태좋음 S급")
                        .price(300000)
                        .build()
        );
        when(springDataProductRepository.findAll()).thenReturn(productJpaEntityList);

        // when
        productLoadPersistenceAdapter.searchProductListQuery(query);

        // then
        verify(springDataProductRepository, times(1)).findAll();
    }

}
