package com.server.market.dtos.product;

import com.server.market.models.product.option.ProductOption;

import java.util.List;

public record ProductOptionDto(String id,
                               String name,
                               List<ProductOptionItemDto> items) {
    public static ProductOptionDto of(ProductOption productOption) {
        return new ProductOptionDto(
            productOption.id().toString(),
            productOption.name(),
            productOption.items().stream().map(ProductOptionItemDto::of).toList()
        );
    }
}
