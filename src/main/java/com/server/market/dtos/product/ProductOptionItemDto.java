package com.server.market.dtos.product;

import com.server.market.models.product.option.ProductOptionItem;

public record ProductOptionItemDto(String id, String name) {
    public static ProductOptionItemDto of(ProductOptionItem productOptionItem) {
        return new ProductOptionItemDto(
            productOptionItem.id().toString(),
            productOptionItem.name()
        );
    }
}
