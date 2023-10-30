package com.vandemarket.productservice.product.application.service;

import com.vandemarket.productservice.common.annotation.UseCase;
import com.vandemarket.productservice.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.productservice.product.application.port.in.GetProductQuery;
import com.vandemarket.productservice.product.application.port.in.GetProductUseCase;
import com.vandemarket.productservice.product.application.port.out.LoadProductPort;
import com.vandemarket.productservice.product.application.port.in.GetProductListQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class LoadProductService implements GetProductUseCase {
    private final LoadProductPort loadProductPort;
    @Override
    public ProductResponse getProduct(GetProductQuery query) {
        return loadProductPort.loadByGetProductQuery(query);
    }

    @Override
    public List<ProductResponse> getProductList(GetProductListQuery query) {
        return loadProductPort.searchProductListQuery(query);
    }
}
