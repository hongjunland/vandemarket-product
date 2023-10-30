package com.vandemarket.productservice.product.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class GetProductQuery {
    private Long productId;
}
