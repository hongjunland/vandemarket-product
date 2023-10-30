package com.vandemarket.productservice.product.application.port.in;

import com.vandemarket.productservice.product.adapter.in.web.response.ProductResponse;

import java.util.List;

public interface GetProductUseCase {
    ProductResponse getProduct(GetProductQuery query);
    List<ProductResponse> getProductList(GetProductListQuery query);
}
