package com.vandemarket.productservice.product.application.port.out;

import com.vandemarket.productservice.product.domain.Product;

public interface CreateProductPort {
    boolean createProduct(Product product);
}
