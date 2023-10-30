package com.vandemarket.product.product.application.port.in;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Builder
public class GetProductListQuery {
    private String name;
}
