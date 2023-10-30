package com.vandemarket.product.product.application.service;

import com.vandemarket.product.common.annotation.UseCase;
import com.vandemarket.product.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.product.product.application.port.in.GetProductListQuery;
import com.vandemarket.product.product.application.port.in.GetProductQuery;
import com.vandemarket.product.product.application.port.in.GetProductUseCase;
import com.vandemarket.product.product.application.port.out.LoadProductPort;
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
