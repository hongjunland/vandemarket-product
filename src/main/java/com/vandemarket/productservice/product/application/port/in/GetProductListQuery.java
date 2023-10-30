package com.vandemarket.productservice.product.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GetProductListQuery {
    private String name;
}
