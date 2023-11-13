package com.vandemarket.productservice.product.domain;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Product {
    private final ProductId id;
    private final Long writer;
    private final String name;
    private final String description;
    private final int price;

    public static Product withId(ProductId id, Long writer, String name, String description, int price) {
        return new Product(
        id,
        writer,
        name,
        description,
        price);
    }
    public static Product withoutId(Long writer, String name, String description, int price) {
        return new Product(
                null,
                writer,
                name,
                description,
                price);
    }

    @Value
    public static class ProductId{
        private final Long value;
    }
}
