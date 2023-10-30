package com.vandemarket.productservice.product.adapter.out.persistence;

import com.vandemarket.productservice.product.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductPersistenceAdapterTest {
    @InjectMocks
    private ProductPersistenceAdapter productPersistenceAdapter;
    @Mock
    private SpringDataProductRepository springDataProductRepository;

    @Test
    @DisplayName("상품 등록 성공")
    public void createProductTest(){
        Product product = Product.withoutId("IPhone 13","상태 좋음 아무나 사셈", 30000);
        when(springDataProductRepository.save(any(ProductJpaEntity.class))).thenReturn(any());
        // when
        productPersistenceAdapter.createProduct(product);
        // then
        verify(springDataProductRepository, times(1)).save(any(ProductJpaEntity.class));

    }

}
