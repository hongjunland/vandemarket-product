package com.vandemarket.product.product.adapter.in.web;

import com.vandemarket.product.common.annotation.WebAdapter;
import com.vandemarket.product.product.adapter.in.web.request.ProductCreateRequest;
import com.vandemarket.product.product.application.port.in.CreateProductUseCase;
import com.vandemarket.product.product.application.port.in.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
class ProductController{
    private final CreateProductUseCase createProductUseCase;
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateRequest productCreateRequest){
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .name(productCreateRequest.getName())
                .description(productCreateRequest.getDescription())
                .price(productCreateRequest.getPrice())
                .build();
        boolean result = createProductUseCase.createProduct(createProductCommand);
        return ResponseEntity.ok(result);
    }

}