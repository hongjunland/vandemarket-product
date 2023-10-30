package com.vandemarket.productservice.product.adapter.in.web.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class ProductCreateRequest{
    private String name;
    private String description;
    private int price;

}
