package com.vandemarket.productservice.product.adapter.out.persistence;

import com.vandemarket.productservice.common.annotation.PersistenceAdapter;
import com.vandemarket.productservice.product.application.port.out.CreateProductPort;
import com.vandemarket.productservice.product.domain.Product;
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
