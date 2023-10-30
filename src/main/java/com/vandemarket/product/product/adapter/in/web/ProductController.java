package com.vandemarket.product.product.adapter.in.web;

import com.vandemarket.product.common.annotation.WebAdapter;
import com.vandemarket.product.product.adapter.in.web.request.ProductCreateRequest;
import com.vandemarket.product.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.product.product.application.port.in.CreateProductUseCase;
import com.vandemarket.product.product.application.port.in.GetProductListQuery;
import com.vandemarket.product.product.application.port.in.GetProductQuery;
import com.vandemarket.product.product.application.port.in.GetProductUseCase;
import com.vandemarket.product.product.application.port.in.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
class ProductController{
    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
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
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId){
        GetProductQuery query = GetProductQuery.builder()
                .productId(productId)
                .build();
        ProductResponse productResponse = getProductUseCase.getProduct(query);
        return ResponseEntity.ok(productResponse);
    }
    @GetMapping
    public ResponseEntity<?> getProductList(@RequestParam String name){
        GetProductListQuery getProductListQuery = GetProductListQuery.builder()
                .name(name)
                .build();
        List<ProductResponse> responses = getProductUseCase.getProductList(getProductListQuery);
        return ResponseEntity.ok(responses);
    }

}