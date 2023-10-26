package com.vandemarket.product.product.application.port.out;

import com.vandemarket.product.product.domain.Product;

public interface CreateProductPort {
    boolean createProduct(Product product);
}
