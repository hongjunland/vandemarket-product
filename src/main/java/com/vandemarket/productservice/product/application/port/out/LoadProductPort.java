package com.vandemarket.productservice.product.application.port.out;

import com.vandemarket.productservice.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.productservice.product.application.port.in.GetProductListQuery;
import com.vandemarket.productservice.product.application.port.in.GetProductQuery;

import java.util.List;

public interface LoadProductPort {
    ProductResponse loadByGetProductQuery(GetProductQuery query);
    List<ProductResponse> searchProductListQuery(GetProductListQuery query);
}
