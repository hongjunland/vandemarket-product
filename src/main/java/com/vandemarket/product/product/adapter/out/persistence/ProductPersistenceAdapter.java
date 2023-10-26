package com.vandemarket.product.product.adapter.out.persistence;

import com.vandemarket.product.common.annotation.PersistenceAdapter;
import com.vandemarket.product.product.application.port.out.CreateProductPort;
import com.vandemarket.product.product.domain.Product;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
class ProductPersistenceAdapter implements CreateProductPort {
    private final SpringDataProductRepository springDataProductRepository;
    @Override
    public boolean createProduct(Product product) {
        ProductJpaEntity productJpaEntity = ProductJpaEntity.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        springDataProductRepository.save(productJpaEntity);
        return true;
    }
}
