package com.vandemarket.productservice.product.application.port.in;

import com.vandemarket.productservice.product.application.port.in.command.CreateProductCommand;

public interface CreateProductUseCase {
    boolean createProduct(CreateProductCommand createUserCommand);
}
