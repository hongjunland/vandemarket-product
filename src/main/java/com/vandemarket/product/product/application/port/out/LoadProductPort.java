package com.vandemarket.product.product.application.port.out;

import com.vandemarket.product.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.product.product.application.port.in.GetProductListQuery;
import com.vandemarket.product.product.application.port.in.GetProductQuery;
import com.vandemarket.product.product.domain.Product;

import java.util.List;

public interface LoadProductPort {
    ProductResponse loadByGetProductQuery(GetProductQuery query);
    List<ProductResponse> searchProductListQuery(GetProductListQuery query);
}
