package com.vandemarket.product.product.application.port.in;

import com.vandemarket.product.product.adapter.in.web.response.ProductResponse;

import java.util.List;

public interface GetProductUseCase {
    ProductResponse getProduct(GetProductQuery query);
    List<ProductResponse> getProductList(GetProductListQuery query);
}
