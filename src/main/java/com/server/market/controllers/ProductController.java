package com.server.market.controllers;

import com.server.market.application.GetProductDetailService;
import com.server.market.application.GetProductListService;
import com.server.market.dtos.product.ProductDetailDto;
import com.server.market.dtos.product.ProductListDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductListService getProductListService;
    private final GetProductDetailService getProductDetailService;

    public ProductController(GetProductListService getProductListService,
                             GetProductDetailService getProductDetailService) {
        this.getProductListService = getProductListService;
        this.getProductDetailService = getProductDetailService;
    }

    @GetMapping
    public ProductListDto list(
        @RequestParam(required = false) String categoryId
    ) {
        return getProductListService.getProductListDto(categoryId);
    }

    @GetMapping("/{productId}")
    public ProductDetailDto detail(@PathVariable String productId) {
        return getProductDetailService.getProductDetailDto(productId);
    }
}
