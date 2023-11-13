package com.vandemarket.productservice.product.adapter.in.web;

import com.vandemarket.productservice.common.SuccessApiResponse;
import com.vandemarket.productservice.common.annotation.WebAdapter;
import com.vandemarket.productservice.product.application.port.in.CreateProductUseCase;
import com.vandemarket.productservice.product.application.port.in.GetProductListQuery;
import com.vandemarket.productservice.product.application.port.in.command.CreateProductCommand;
import com.vandemarket.productservice.product.adapter.in.web.request.ProductCreateRequest;
import com.vandemarket.productservice.product.adapter.in.web.response.ProductResponse;
import com.vandemarket.productservice.product.application.port.in.GetProductQuery;
import com.vandemarket.productservice.product.application.port.in.GetProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
class ProductController{
    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    @PostMapping
    public SuccessApiResponse<?> createProduct(@RequestBody ProductCreateRequest productCreateRequest, @RequestHeader("X-User-ID") String userId){
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .writer(Long.parseLong(userId))
                .name(productCreateRequest.getName())
                .description(productCreateRequest.getDescription())
                .price(productCreateRequest.getPrice())
                .build();
        boolean result = createProductUseCase.createProduct(createProductCommand);
        return SuccessApiResponse.of(result);
    }
    @GetMapping("/{productId}")
    public SuccessApiResponse<?> getProductById(@PathVariable Long productId){
        GetProductQuery query = GetProductQuery.builder()
                .productId(productId)
                .build();
        ProductResponse productResponse = getProductUseCase.getProduct(query);
        return SuccessApiResponse.of(productResponse);
    }
    @GetMapping
    public SuccessApiResponse<?> getProductList(@RequestParam String name){
        GetProductListQuery getProductListQuery = GetProductListQuery.builder()
                .name(name)
                .build();
        List<ProductResponse> responses = getProductUseCase.getProductList(getProductListQuery);
        return SuccessApiResponse.of(responses);
    }

}