package com.vandemarket.productservice.product.domain;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Product {
    private final ProductId id;
    private final String name;
    private final String description;
    private final int price;

    public static Product withId(ProductId id, String name, String description, int price) {
        return new Product(
        id,
        name,
        description,
        price);
    }
    public static Product withoutId(String name, String description, int price) {
        return new Product(
                null,
                name,
                description,
                price);
    }

    @Value
    public static class ProductId{
        private final Long value;
    }
}
