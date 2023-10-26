package com.vandemarket.product.product.application.service;

import com.vandemarket.product.common.annotation.UseCase;
import com.vandemarket.product.product.application.port.in.CreateProductUseCase;
import com.vandemarket.product.product.application.port.in.command.CreateProductCommand;
import com.vandemarket.product.product.application.port.out.CreateProductPort;
import com.vandemarket.product.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
class CreateProductService implements CreateProductUseCase {
    private final CreateProductPort createProductPort;
    @Override
    public boolean createProduct(CreateProductCommand createProductCommand) {
        Product product = Product.withoutId(createProductCommand.getName(),
                createProductCommand.getDescription(),
                createProductCommand.getPrice());
        return createProductPort.createProduct(product);
    }
}
