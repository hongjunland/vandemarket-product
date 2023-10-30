package com.vandemarket.productservice.product.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
public class CreateProductCommand {
    private String name;
    private String description;
    private int price;
}
