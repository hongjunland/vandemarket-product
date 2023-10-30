package com.vandemarket.product.product.application.port.in;

import com.vandemarket.product.product.adapter.in.web.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class GetProductQuery {
    private Long productId;
}
