package com.vandemarket.product.product.application.port.in;

import com.vandemarket.product.product.application.port.in.command.CreateProductCommand;

public interface CreateProductUseCase {
    boolean createProduct(CreateProductCommand createUserCommand);
}
