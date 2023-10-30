package com.vandemarket.product.product.adapter.out.persistence;

import com.vandemarket.product.common.annotation.PersistenceAdapter;
import com.vandemarket.product.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.product.product.application.port.in.GetProductListQuery;
import com.vandemarket.product.product.application.port.in.GetProductQuery;
import com.vandemarket.product.product.application.port.in.GetProductUseCase;
import com.vandemarket.product.product.application.port.out.LoadProductPort;
import com.vandemarket.product.product.domain.Product;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
class ProductLoadPersistenceAdapter implements LoadProductPort {
    private final SpringDataProductRepository springDataProductRepository;
    @Override
    public ProductResponse loadByGetProductQuery(GetProductQuery query) {
        ProductJpaEntity productJpaEntity = springDataProductRepository.findById(query.getProductId()).orElse(null);
        return ProductResponse.builder()
                .id(productJpaEntity.getId())
                .name(productJpaEntity.getName())
                .description(productJpaEntity.getDescription())
                .price(productJpaEntity.getPrice())
                .build();
    }

    @Override
    public List<ProductResponse> searchProductListQuery(GetProductListQuery query) {
        List<ProductJpaEntity> productJpaEntities = springDataProductRepository.findAll();
        List<ProductResponse> responses = productJpaEntities.stream()
                .map((entity) ->
                    ProductResponse.builder()
                            .id(entity.getId())
                            .name(entity.getName())
                            .description(entity.getDescription())
                            .price(entity.getPrice())
                    .build()
        ).collect(Collectors.toList());
        return responses;
    }
}
